using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Unity.AI.Navigation;

public class NavMeshManager : MonoBehaviour
{
    public static NavMeshManager current;
    [SerializeField]
    private NavMeshSurface surface;
    [SerializeField]
    private NavMeshAgent agent;
    

    void Awake()
    {
        current = this;
    }
    void Update()
    {
    }
    public void Bake()
    {
        surface.UpdateNavMesh();
    }
    
}
