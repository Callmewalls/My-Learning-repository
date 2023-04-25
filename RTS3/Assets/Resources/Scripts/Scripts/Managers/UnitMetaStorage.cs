using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class UnitMetaStorage : MonoBehaviour
{
    public static UnitMetaStorage current;
    
    public UnitMetaData[] unitMetaList;
    public UnitMetaData[] buildingMetaList;
    
    //===============================================
    void Awake()
    {
        current = this;
    }
    
    //===============================================
    public UnitMetaData GetUnitMetaByName(string name)
    {
        UnitMetaData unitMetaData = null;

        for (int i = 0; i < unitMetaList.Length; i++)
        {
            if(this.unitMetaList[i].name == name)
            {
                unitMetaData = this.unitMetaList[i];
            }
            
        }

        return unitMetaData;
    }

    public UnitMetaData GetBuildingMetaByName(string name)
    {
        UnitMetaData unitMetaData = null;

        for (int i = 0; i < buildingMetaList.Length; i++)
        {
            if(this.buildingMetaList[i].name == name)
            {
                unitMetaData = this.buildingMetaList[i];
            }
            
        }

        return unitMetaData;
    }
}

[System.Serializable]
public class UnitMetaData 
{
    public string name;
    public GameObject prefab;
    public int price;
}

