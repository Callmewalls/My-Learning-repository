using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Weapon : MonoBehaviour
{
    [Header("Weapon Stats")]
    public int damage = 5;
    public float coolDownTime = 1f;

    [Header("World objects")]
    public Transform shootPoint;
    public GameObject projectilePrefab;

    private float time;

    private UnitBehavour unitBehavour;

    public bool isReady
        {
            get;
            private set;
        }

    void Start() 
    {
        time = 0;    
        isReady = true;
        unitBehavour = GetComponent<UnitBehavour>();
    }

    void Update() 
    {
        if(!isReady)
        {
            time += Time.deltaTime;

            if(time > coolDownTime)
            {
                isReady = true;
                time = 0;
            }
        }
    }

    public void Shoot()
    {
        isReady = false;
        GameObject p = Instantiate(
            projectilePrefab, 
            shootPoint.position,
            shootPoint.rotation
        );
        p.GetComponent<Projectile>().weapon = this;
    }

    public void OnProjectileCollision(Projectile p, UnitBehavour unitBehavour)
    {
        if(unitBehavour.faction != this.unitBehavour.faction)
        {
            unitBehavour.GetComponent<Health>().health -= damage;
            Destroy(p.gameObject);
        }
        else
        {   
            //Physics.IgnoreCollision(p.gameObject.GetComponent<Collider>(), unitBehavour.gameObject.GetComponent<Collider>(), true);
        }
    }
}
