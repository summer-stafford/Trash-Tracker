package com.example.summerstafford.trashapplication;

public class WasteItem {
    public String name;
    public int interactTotal;
    public int wasteTotal;

    public WasteItem(String name){
        this.name = name;
        this.interactTotal = 0;
        this.wasteTotal = 0;
    }
}
