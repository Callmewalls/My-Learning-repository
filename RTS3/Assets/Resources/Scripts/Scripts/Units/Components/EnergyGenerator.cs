using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnergyGenerator : MonoBehaviour
{
    public float productionRate = 10;

    public float maxBattery = 100;

    private float battery = 0;

    private UnitBehavour unitBehavour;

    private float time = 0;

    //==================================
    void Start()
    {
        this.unitBehavour = GetComponent<UnitBehavour>();
        if(this.unitBehavour == null){Debug.LogError("This isnt a valid Unit");}
    }

    //==================================
    void Update()
    {
        this.time += Time.deltaTime;

        this.battery += Time.deltaTime * this.productionRate;
        if(this.battery > maxBattery)
        {
            this.battery = maxBattery;
        }
        
        if(this.time > 1)
        {
            time = 0;
            this.battery -= this.unitBehavour.faction.StoreEnergy( Mathf.RoundToInt(this.battery-0.5f));
        }
    }
}
