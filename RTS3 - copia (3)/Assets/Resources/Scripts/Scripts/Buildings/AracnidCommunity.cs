using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEditor;

public class AracnidCommunity : UnitBehavour
{   
    public GameObject buildingToPlace;
    private int count = 0;
    // =================================================
    public override void Init()
    { 
        count++;
    }
    
    
    // =================================================
    private void Update() 
    {   
    }

    
    // =================================================
    public override void OnSelectionChanged()
    {   
        count++;
        if(count >= 3){
        
            UIManager.current.ToggleAracnidCommunityPanel(this.IsSelected);
        }
    }
    // =================================================
    public void ExpandCommunity()
    {   
        Vector3 random = RandomSpawnAround();

        faction = GameObject.Find("PlayerFaction").GetComponent<Faction>();
        GameObject g = Instantiate(
            this.gameObject,
            random,
            Quaternion.identity
        );
        UnitBehavour u = g.GetComponent<UnitBehavour>();
        u.faction = faction;
        u.Init();
    }

    // =================================================
    static Vector3 RandomSpawnAround()
    {   
        float[] moreless = new float[2]{-1f, 1f};
        int result = Mathf.RoundToInt(Random.Range(0f, 1f));
        float radio =30;
        float x  = Random.Range(-radio,radio);

        Vector3 tt = GameObject.Find("PlayerFaction").GetComponent<PlayerUnitManager>().selectedUnits[0].gameObject.transform.position;

        Vector3 random = new Vector3(
            tt.x + x,
            0, 
            tt.z + moreless[result] * Mathf.Sqrt(Mathf.Pow(radio, 2) - Mathf.Pow(x, 2))
        );

        return random;
    }
}