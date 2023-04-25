using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class UnitBehavour : MonoBehaviour
{   
    public GameObject selectionMarker;
    public UnitManager unitManager;
    public Faction faction;
    public Renderer[] coloringUnits;
    
    protected bool selected;

    public bool IsSelected
    {
        get
        {
            return this.selected;
        }
        set
        {
            // Mostrar u ocultar el icono de seleccion
            this.selectionMarker.SetActive(value);
            this.selected = value;
            this.OnSelectionChanged();
        }
    }
    

    // =====================================
    public void Start() 
    {   
        this.IsSelected = false;

        this.unitManager = faction.unitManager;

        this.unitManager.units.Add(this);
                                                                                                //foreach(UnitBehavour u in unitManager.units){Debug.Log(u.gameObject.name); }
        foreach(Renderer r in coloringUnits)
        {
            r.material = faction.factionColor;
        }
        Init();
                                                                                                //Debug.Log("Aqui llego");
    }
    // =====================================
    private void OnDestroy() 
    {
        unitManager.RemoveUnit(this);
    }
    // =====================================
    public virtual void OnSelectedUnits(){}
    // =====================================
    public virtual void Init(){}
    // =====================================
    public virtual void OnRightClick(Vector3 worldPos){}
    // ===============================
    public virtual void OnSelectionChanged(){}
}
