using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Health : MonoBehaviour
{

    public int maxHealth;
    
    public int health
    {
        get{return currentHealth;}
        set
        {
            currentHealth = value;

            currentHealth = Mathf.Clamp(currentHealth, 0, maxHealth);

            if(currentHealth == 0)
            {
                Destroy(gameObject);
            }
        }
    }

    private int currentHealth;

    private void Awake() 
    {
        currentHealth = maxHealth;    
    }
}
