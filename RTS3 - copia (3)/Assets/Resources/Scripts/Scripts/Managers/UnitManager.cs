using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class UnitManager : MonoBehaviour
{
    [Header("Units")]
    public List<UnitBehavour> units;
    public Faction faction;

    private void Awake() 
    {
        faction.GetComponent<Faction>();
    }

    public virtual void RemoveUnit(UnitBehavour u)
    {
        units.Remove(u);
    }
}
