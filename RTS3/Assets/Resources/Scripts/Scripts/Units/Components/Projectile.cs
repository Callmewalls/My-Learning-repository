using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[RequireComponent(typeof(Rigidbody))]
public class Projectile : MonoBehaviour
{
    public float speed = 15;

    public Weapon weapon;

    public float duration = 10;

    void Start() 
    {
        Destroy(this.gameObject, duration);

        GetComponent<Rigidbody>().velocity = transform.forward * speed;
    }

    private void OnCollisionEnter(Collision other)
    {
        UnitBehavour u = other.gameObject.GetComponent<UnitBehavour>();

        if(u != null)
        {
            weapon.OnProjectileCollision(this, u);
        }
        else
        {
            Destroy(gameObject);
        }
    }
}
