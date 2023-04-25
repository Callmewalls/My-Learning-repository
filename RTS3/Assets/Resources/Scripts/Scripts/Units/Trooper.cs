using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class Trooper : UnitBehavour
{   
    public LayerMask unitsLayer;
    public float maxCombatDistance = 10;

    private NavMeshAgent agent;
    
    private float time;
    private float timeOut = 1f;

    private Weapon weapon;
    
    private UnitBehavour currentTarget;

    // Start is called before the first frame update
    public override void Init()
    {
        agent = GetComponent<NavMeshAgent>();
        weapon = GetComponent<Weapon>();
    }

    public virtual void Init2(){}

    // Update is called once per frame
    void Update()
    {
        time += Time.deltaTime;
        // Reloj, cada segundo comprueba si hay enemigos
        if(time > timeOut)
        {
            time = 0;

            //Mirar alrededor

            if(currentTarget == null)
            {
                CheckSurrounding();
            }
            else
            {
                float distance = Vector3.Distance(
                    transform.position, currentTarget.transform.position
                );

                if(distance > maxCombatDistance )
                {
                    currentTarget = null;
                }
            }
        }

        if(currentTarget != null)
        {   
            Vector3 target = new Vector3(currentTarget.transform.position.x, this.transform.position.y, currentTarget.transform.position.z);
            this.transform.LookAt(target);
            if(weapon.isReady)
            {   
                weapon.Shoot();
            }
        }
    }

    public void CheckSurrounding()
    {
        //comprobar enemigos
        Collider[] nearUnits = Physics.OverlapSphere(
            transform.position,
            maxCombatDistance + 1,
            unitsLayer
        );
        

        for (int i = 0; i < nearUnits.Length; i++)
        {
            if(nearUnits[i].gameObject != this.gameObject)
            {
                if(nearUnits[i].gameObject.GetComponent<UnitBehavour>() != null)
                {
                    UnitBehavour possibleEnemy = nearUnits[i].GetComponent<UnitBehavour>();

                    if(possibleEnemy.faction != this.faction)
                    {
                        currentTarget = possibleEnemy;
                    }
                }
                
            }
        }
    }


    public override void OnRightClick(Vector3 worldPos)
    {
        agent.SetDestination(worldPos);
    }
}