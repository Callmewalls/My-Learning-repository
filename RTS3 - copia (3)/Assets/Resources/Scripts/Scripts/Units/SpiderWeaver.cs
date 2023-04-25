using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpiderWeaver : Trooper
{

    private int count = 1;

    // ===================================
    public override void Init2()
    { 
        count++;
    }

    

    // ===================================
    void Update()
    {
        
    }

    // =================================================
    public override void OnSelectionChanged()
    {   
        count++;
        if(count >= 3){
            
            UIManager.current.ToggleSpiderWeaverPanel(this.IsSelected);
            
        }
    }
}
