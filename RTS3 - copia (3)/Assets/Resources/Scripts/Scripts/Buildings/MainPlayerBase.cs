using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MainPlayerBase : UnitBehavour
{
    public GameObject spiderSoldier;
    public GameObject spiderSpitter;
    public GameObject spiderWeaver;

    [Header("Unit positions")]
    public Transform spawnPoint;
    public Transform targetPoint;


    // ============================================
    public override void Init()
    {
        
    }

    // ============================================
    public void createUnit(string unitName)
    {
      MainPlayerBase mainActiveBase = PlayerUnitManager.current.selectedUnits[0].gameObject.GetComponent<MainPlayerBase>();

      UnitMetaData unitMetaData = UnitMetaStorage.current.GetUnitMetaByName(unitName);

      if(this.faction.CanRetrieveEnergy(unitMetaData.price))
      {
        GameObject g = Instantiate(
            unitMetaData.prefab,
            mainActiveBase.spawnPoint.position,
            Quaternion.identity
        );

        UnitBehavour u = g.GetComponent<UnitBehavour>();
        u.faction = this.faction;
        u.Init();
        u.OnRightClick(mainActiveBase.targetPoint.position); 

        this.faction.RetrieveEnergy(unitMetaData.price);
      }
    }

    // ============================================
    public override void OnRightClick(Vector3 worldPos)
    {
        targetPoint.position = worldPos + new Vector3(0, targetPoint.transform.position.y, 0);
    }

    // ============================================
    public override void OnSelectionChanged()
    {
      UIManager.current.ToggleMainBasePanel(this.selected);
    }
}
