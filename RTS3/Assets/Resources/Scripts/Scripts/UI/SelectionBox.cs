using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SelectionBox : MonoBehaviour
{   
    public Rect selectionRect;

    private RectTransform rectTransform;
    
    private Vector3 mouseStart;


    private float minSize;
    // Start is called before the first frame update
    void Start()
    {
        selectionRect.Set(0, 0, 0, 0);

        rectTransform = GetComponent<RectTransform>();
        rectTransform.gameObject.SetActive(false);
    }

// ======================================================================
    public void Begin(Vector3 mousePosition)
    {   
        mouseStart = mousePosition;

        selectionRect.Set(mousePosition.x, mousePosition.y, 0, 0);
        
        
        rectTransform.gameObject.SetActive(true);

        rectTransform.offsetMin = selectionRect.min;
        rectTransform.offsetMax = selectionRect.max;
        

        minSize =(Screen.width * 0.1f + Screen.height * 0.05f)/2;
    }
    
    public bool IsValid()
    {
        return  selectionRect.size.magnitude > minSize;
    }

   // ======================================================================

   public void Drag(Vector3 mousePosition)
   { 
        // Arrastrando hacia la izquierda
        if(mousePosition.x < mouseStart.x)
        {
            selectionRect.xMin = mousePosition.x;
            selectionRect.xMax = mouseStart.x;
        }
        // Arrastrando hacia la derecha
        else
        {
            selectionRect.xMin = mouseStart.x;
            selectionRect.xMax = mousePosition.x;
        }
        // Arrastrando hacia abajo
        if(mousePosition.y < mouseStart.y)
        {
            selectionRect.yMin = mousePosition.y;
            selectionRect.yMax = mouseStart.y;
        }
        // Arrastrando hacia arriba
        else
        {
            selectionRect.yMin = mouseStart.y;
            selectionRect.yMax = mousePosition.y;
        }


        rectTransform.offsetMin = selectionRect.min;
        rectTransform.offsetMax = selectionRect.max;
   }
    // ======================================================================

   public void End()
    {
        rectTransform.gameObject.SetActive(false);
    }
}
