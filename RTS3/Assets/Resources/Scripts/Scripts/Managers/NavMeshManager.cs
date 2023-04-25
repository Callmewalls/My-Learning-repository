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
    UnityEngine.AI.NavMeshData NavMeshData;
    

    void Awake()
    {
        current = this;
        NavMeshData = new UnityEngine.AI.NavMeshData();
        surface.BuildNavMesh();
    }
    void Update()
    {
    }
    public void Bake()
    {
        surface.UpdateNavMesh(NavMeshData);
    }
    
}
