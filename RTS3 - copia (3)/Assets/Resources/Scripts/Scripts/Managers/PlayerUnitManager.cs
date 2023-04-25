using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.UI;

public class PlayerUnitManager : UnitManager
{
    public static PlayerUnitManager current;

    public List<UnitBehavour> selectedUnits;

    [Header("Player stuff")]
    public Camera mainCamera;
    public SelectionBox selectionBox;
    private Plane groundPlane;
    [SerializeField]LayerMask UILayer;

    PointerEventData m_PointerEventData;
    [SerializeField]EventSystem m_EventSystem;
    List<RaycastResult> results = new List<RaycastResult>();

    private bool selecting;

    void Awake()
    {
        current = this;
    }
    // ==============================================================
    void Start()
    {

        groundPlane.SetNormalAndPosition(Vector3.up, Vector3.zero);

        selecting = false;
    }    


    // ==============================================================
    void Update()
    {
        m_PointerEventData = new PointerEventData(m_EventSystem);
        m_PointerEventData.position = Input.mousePosition;
        EventSystem.current.RaycastAll(m_PointerEventData, results);

        if(!BuildManager.current.IsBuilding)
        {   
                if(Input.GetMouseButtonDown(0))
                {
                    if(results.Count > 0)
                    {
                    }
                    else
                    {
                        foreach(UnitBehavour u in selectedUnits)
                        {
                            u.IsSelected = false;
                        }  
                        selectedUnits.Clear();
                        selecting = true;
                        selectionBox.Begin(Input.mousePosition);
                    }
                }
                {

                }
            

            if(selecting)
            {
                if(Input.GetAxis("Mouse X") != 0 || Input.GetAxis("Mouse Y") != 0)
                {
                    // Arrastrando
                    selectionBox.Drag(Input.mousePosition);

                    //Seleccionar Unidades
                    foreach(UnitBehavour u in units)
                    {
                        Vector2 screenCoord = mainCamera.WorldToScreenPoint(u.transform.position);
                        if(selectionBox.selectionRect.Contains(screenCoord))
                        {
                            if(! u.IsSelected)
                            {
                                
                                selectedUnits.Add(u);
                                u.IsSelected = true;
                            }
                        }
                        else
                        {
                            if(u.IsSelected)
                            {
                                
                                selectedUnits.Remove(u);
                                u.IsSelected = false;
                            }
                        }
                    }

                }
            }

            if(Input.GetMouseButtonUp(0))
            {   

                selectionBox.End();
                selecting = false;
                if(results.Count > 0)
                {
                    //foreach(RaycastResult r in results){Debug.Log(r.gameObject.name);}
                }
                else
                {
                    

                    if(!selectionBox.IsValid())
                    {
                        // Limpiar selección anterior
                        foreach(UnitBehavour u in selectedUnits)
                        {
                            u.IsSelected = false;
                        }
                        selectedUnits.Clear();

                        Ray ray = mainCamera.ScreenPointToRay(Input.mousePosition);
                        RaycastHit info;

                        if(Physics.Raycast(ray, out info, 250))
                        {
                            GameObject go = info.collider.gameObject;
                            UnitBehavour u = go.GetComponent<UnitBehavour>();
                            
                            if(u != null)
                            {   
                                if(units.Contains(u))
                                {
                                    u.IsSelected =  true;
                                    selectedUnits.Add(u);
                                }
                            }
                        }
                    }
                } 
            }


            if(Input.GetMouseButtonDown(1))
            {   
                Ray ray = mainCamera.ScreenPointToRay(Input.mousePosition);
                float distance;

                groundPlane.Raycast(ray, out distance);
                Vector3 point = ray.GetPoint(distance);

                foreach(UnitBehavour u in selectedUnits)
                {
                    u.OnRightClick(point);
                }
            }
        }
    }

    // ==============================================================
    public override void RemoveUnit(UnitBehavour u)
    {
        units.Remove(u);
        selectedUnits.Remove(u);
    }
}
