package com.example.summerstafford.trashapplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import android.content.Context;

public abstract class CompileData extends TimerTask {
    protected HashMap<Date, ArrayList<Integer>> userInteractions = new HashMap<>();

    @Override
    public void run(){
        //TASK 1 : GET INFORMATION FROM EVERY CATEGORY
        ArrayList<WasteItem> kitchenList = Kitchen.getData();

        //TASK 2 : COMPILE INFORMATION INTO ORGANIZED HASHMAP

        //TASK 2.1 : SCROLL THROUGH ARRAYLIST AND TOTAL ENTIRE CATEGORY
        int[] kitchenTotal = getTotal(kitchenList);

        //TASK 2.2 : ADD ALL ARRAYS INTO TOTAL ARRAY
        ArrayList<Integer> dailyTotals = new ArrayList<>();
        dailyTotals.add(kitchenTotal[0]);
        dailyTotals.add(kitchenTotal[1]);


        //TASK 2.3 : GET DATE
        Date today = new Date( );
        //SimpleDateFormat ft = new SimpleDateFormat ("E MM/dd/yyyy");

        //TASK 2.4 : ADD DATE AND dailyTotals TO userInteractions
        userInteractions.put(today, dailyTotals);


        //TASK 3 : RESET EACH CATEGORY TOTALS
        Kitchen.resetNumbers();

    }

    public int[] getTotal(ArrayList<WasteItem> mList){
        int total = 0;
        int wasteTotal = 0;
        //TOTAL INTERACTIONS AND WASTE
        for(int i = 0; i < mList.size(); i++){
            total += mList.get(i).interactTotal;
            wasteTotal += mList.get(i).wasteTotal;
        }
        int[] totals = new int[]{total, wasteTotal};
        return totals;
    }

    public HashMap<Date, ArrayList<Integer>> getData(){
        return userInteractions;
    }
}
