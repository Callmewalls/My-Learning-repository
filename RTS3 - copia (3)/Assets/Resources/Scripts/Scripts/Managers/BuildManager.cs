using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class BuildManager : MonoBehaviour
{          
    public static BuildManager current;
    public LayerMask whereToPlace;
    public Camera mainCamera;
    
    private Faction faction;
    private UnitMetaData unitMetaData;
    private GameObject buildingToPlace;
    private string buildingName;
    private bool building;
    public bool IsBuilding
    {
        get
        {
            return this.building;
        }
        set
        {
            this.building = value;
        }
    }


    // ==========================================
    void Awake()
    {
        current = this;
        this.IsBuilding = false;
        this.buildingName = null;
        this.unitMetaData = null;
    }

    void Start()
    {
        faction = GameObject.Find("PlayerFaction").GetComponent<Faction>();
    }

    // ============================================
    void Update()
    {
        if(this.IsBuilding)
        {   
            Ray ray = mainCamera.ScreenPointToRay(Input.mousePosition);
            RaycastHit info;

            if(Physics.Raycast(ray,out info,  200, whereToPlace))
            {
                this.buildingToPlace.transform.position = info.point;
                if(Input.GetMouseButtonDown(0))
                {
                    Destroy(this.buildingToPlace);
                    current.placeTheBuilding();
                }
            }
        }
    }

    // ==========================================
    public void createBuilding(string buildingName)
    {   
        this.IsBuilding = true;
        this.buildingName = buildingName;
        this.unitMetaData = UnitMetaStorage.current.GetBuildingMetaByName(buildingName);

        this.buildingToPlace = Instantiate(this.unitMetaData.prefab.transform.GetChild(0).gameObject, Vector3.zero, Quaternion.identity);
    }

    // ==========================================
    public void placeTheBuilding()
    {
        if(faction.CanRetrieveEnergy(unitMetaData.price))
        { 
            Ray ray = mainCamera.ScreenPointToRay(Input.mousePosition);
            RaycastHit info;

            foreach(UnitBehavour u in PlayerUnitManager.current.selectedUnits)
            {
                if(u.GetComponent<SpiderWeaver>() != null)
                {
                    u.OnRightClick(Input.mousePosition);
                }
            }

            if(Physics.Raycast(ray,out info,  400, whereToPlace))
            {   
                this.buildingToPlace = Instantiate(this.unitMetaData.prefab, info.point, Quaternion.identity);
                UnitBehavour u = this.buildingToPlace.GetComponent<UnitBehavour>();
                u.faction = faction;
                u.Start(); 
                faction.RetrieveEnergy(unitMetaData.price);
                this.buildingName = null;
                this.unitMetaData = null;
                this.IsBuilding = false;
                NavMeshManager.current.Bake();
                Debug.Log("llego");
            }
        }
    }

}
