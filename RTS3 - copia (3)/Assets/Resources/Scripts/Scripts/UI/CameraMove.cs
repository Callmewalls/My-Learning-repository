using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraMove : MonoBehaviour
{
    public Transform cameraAnchor;
    public Transform cameraPivot;
    public float speed = 10;
    public Camera mainCamera;
    Ray ray;

    private int borderL;
    private Vector2 resolucion;
    private Vector2 middleScreen;

    private Vector3 defaultTransform;
    private Vector3 movement;
    public Transform corner1;
    public Transform corner2;

    private Bounds bounds;

    // Start is called before the first frame update
    void Start()
    {
        Vector3 center = Vector3.Lerp(corner1.position, corner2.position, 0.5f);
        Vector3 size = new Vector3(
                Mathf.Abs(corner2.position.x - corner1.position.x),
                Mathf.Abs(290),
                Mathf.Abs(corner2.position.z - corner1.position.z)
            );
        
        defaultTransform = new Vector3(325.799988f,53.2000008f,325.799988f);
        bounds = new Bounds(center, size);

        borderL = 5;
        resolucion =  new Vector2(Screen.width - this.borderL, Screen.height - this.borderL);
        middleScreen = new Vector2(Screen.width/2,Screen.height/2);
    }

    // Update is called once per frame
    void Update()
    {   
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        // Movimiento awsd
        if(horizontal != 0 ||vertical != 0)
        {   
            movement.Set(horizontal, 0, vertical);
            cameraAnchor.transform.Translate(movement*0.4f);
  
            // Bloqueo de la cámara
            cameraAnchor.transform.position = bounds.ClosestPoint(
                cameraAnchor.transform.position + movement * Time.deltaTime * speed
            );

        }

        if(Input.GetKey(KeyCode.Space))
        {
            cameraAnchor.transform.position = defaultTransform;
        }

    //Ratón por el borde de la pantalla
        if(Input.GetAxis("Mouse X") != 0 || Input.GetAxis("Mouse Y") != 0)
        {   
            Vector2 mouse = Input.mousePosition;
            if((Input.mousePosition.x < borderL) || (Input.mousePosition.x > resolucion.x) || (Input.mousePosition.y < borderL) || (Input.mousePosition.y > resolucion.y))
            {
            movement = mouse - middleScreen;
            movement.z = movement.y;
            movement.y = 0;
            movement = movement.normalized / 2;

            cameraAnchor.Translate(movement);

            cameraAnchor.transform.position = bounds.ClosestPoint(
                cameraAnchor.transform.position + movement * Time.deltaTime * speed
            );
            }
        }
        // Rotación en eje Y de la cámara
        if(Input.GetKey(KeyCode.Q))
        {
            cameraAnchor.Rotate(0, -0.5f, 0);
        }
        else if(Input.GetKey(KeyCode.E))
        {
            cameraAnchor.Rotate(0, 0.5f, 0);
        }

        // Rotación en eje X de la cámara
        if(Input.GetKey(KeyCode.C))
        {
            cameraPivot.Rotate(0.5f,0,0);
        }
        if(Input.GetKey(KeyCode.V))
        {
            cameraPivot.Rotate(-0.5f,0,0);
        }
        
        // Zoom
        if(Input.GetAxis("Mouse ScrollWheel") < 0f && cameraAnchor.transform.position.y < 100)
        {   
            cameraAnchor.Translate(0, 6f, -6f);
        }
        else if(Input.GetAxis("Mouse ScrollWheel") > 0f && cameraAnchor.transform.position.y > 10)
        {
            cameraAnchor.Translate(0, -6f, 6f);
        }
        if(Input.GetKey(KeyCode.Z))
        {
            movement.Set(0, 0.3f, -0.3f);
            cameraAnchor.transform.Translate(movement);
  
            // Bloqueo de la cámara
            cameraAnchor.transform.position = bounds.ClosestPoint(
                cameraAnchor.transform.position + movement * Time.deltaTime * speed
            );
            
        }
        if(Input.GetKey(KeyCode.X))
        {
            movement.Set(0, -0.3f, 0.3f);
            cameraAnchor.transform.Translate(movement);
  
            // Bloqueo de la cámara
            cameraAnchor.transform.position = bounds.ClosestPoint(
                cameraAnchor.transform.position + movement * Time.deltaTime * speed
            );
        }
    }
    // Gizmos que define el área del terreno
    void OnDrawGizmos() 
    {   
        if(corner1 != null && corner2 != null)
        {
            Vector3 center = Vector3.Lerp(corner1.position, corner2.position, 0.5f);
            Vector3 size = new Vector3(corner2.position.x - corner1.position.x, 300, corner2.position.z - corner1.position.z);
            Gizmos.color = Color.red;
            Gizmos.DrawWireCube(center, size); 
        }
    }
}
