using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class UIManager : MonoBehaviour
{
    public static UIManager current;

    public GameObject mainBasePanel;
    public GameObject aracnidCommunityPanel;
    public GameObject SpiderWeaverPanel;

    void Awake() 
    {
        current = this;
    }
    // ===============================
    void Start()
    {
        mainBasePanel.SetActive(false);
        aracnidCommunityPanel.SetActive(false);
        SpiderWeaverPanel.SetActive(false);
    }

    // ===============================
    public void ToggleMainBasePanel(bool show)
    {
        mainBasePanel.SetActive(show);
    }

    // ===============================
    public void ToggleAracnidCommunityPanel(bool show)
    {
        aracnidCommunityPanel.SetActive(show);
    }

    // ===============================
    public void ToggleSpiderWeaverPanel(bool show)
    {
        SpiderWeaverPanel.SetActive(show);
    }
}
