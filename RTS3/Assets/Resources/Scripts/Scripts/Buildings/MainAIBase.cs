using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MainAIBase : UnitBehavour
{

    public GameObject trooperPrefab;

    [Header("Unit positions")]
    public Transform spawnPoint;
    public Transform targetPoint;

    private float time;
    private float timeOut;

    private int waveUints;
    private int currentUnits;

    // ===============================
    public override void Init()
    {
        time = 0;
        timeOut = 0.5f;

        waveUints = 40;
        currentUnits = 0;
    }

    // ===============================
    void Update()
    {
        time += Time.deltaTime;
        if(time > timeOut)
        {
            time = 0;

            if(currentUnits < waveUints)
            {   
                if(this.faction.CanRetrieveEnergy(100))
                {
                    GameObject g = Instantiate(
                        trooperPrefab,
                        spawnPoint.position,
                        Quaternion.identity
                    );

                    UnitBehavour u = g.GetComponent<UnitBehavour>();
                    u.faction = this.faction;
                    u.Start();
                    u.unitManager.units.Remove(u);
                    u.OnRightClick(targetPoint.position);  
                    currentUnits++;
                    
                    this.faction.RetrieveEnergy(100);
                }
            }
        }
        
    }
}
