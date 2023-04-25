using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class FactionPanel : MonoBehaviour
{
   
    public Text eneryStorage;

    public void UpdateEnergy(int energy)
    {
        this.eneryStorage.text = energy.ToString();
    }

}
