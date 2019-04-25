package com.example.summerstafford.trashapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class LogInteractions extends AppCompatActivity {
    public HashMap<Date, ArrayList<Integer>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_interactions);

        //REFERENCE LISTVIEW
        ListView listView = findViewById(R.id.list);

        //CREATE ARRAYLIST FOR CATEGORIES
        final ArrayList<Category> categoryList = new ArrayList<>();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                //FILL ARRAYLIST WITH CATEGORIES
                categoryList.add(new Category("Kitchen", R.drawable.category_kitch,  Kitchen.class.getName()));
                categoryList.add(new Category("Cleaning", R.drawable.category_clean, Cleaning.class.getName()));
                categoryList.add(new Category("Bedroom", R.drawable.category_bed,Bedroom.class.getName()));
                categoryList.add(new Category("Bathroom", R.drawable.category_bath, Bathroom.class.getName()));
                categoryList.add(new Category("Shopping", R.drawable.category_shop, Shopping.class.getName()));
                categoryList.add(new Category("Office", R.drawable.category_office, Office.class.getName()));
                categoryList.add(new Category("Food", R.drawable.category_food, Food.class.getName()));
                categoryList.add(new Category("Beauty", R.drawable.category_beaut, Beauty.class.getName()));
                categoryList.add(new Category("Pets", R.drawable.category_pet,Pets.class.getName()));
                categoryList.add(new Category("Other", R.drawable.category_misc, Other.class.getName()));
            }
        };
        r.run();
        //IF YOU ADD CATEGORIES TO LIST, BE SURE TO CHANGE THE DAILY TOTAL ARRAYLIST
        //      IN COMPILEDATA.JAVA


        CategoryAdapter itemsAdapter = new CategoryAdapter(this, categoryList);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                String clsName = view.getContentDescription().toString();
                Class<?> cls = null;
                try {
                    cls = Class.forName(clsName);
                }
                catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(LogInteractions.this, cls);
                startActivity(intent);
            }
        });


        //CREATE A TIMER OBJECT TO COLLECT DATA FROM EACH CATEGORY EVERY DAY AT MIDNIGHT
        //AND STORE IN HASHMAP

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);

        //Timer mTimer = new Timer();
        //TimerTask mTimerTask = new CompileData() {
            //@Override
            //public void run() {
                //super.run();
            //}
        //};
        //Timer executes CompileData() every day at 23:59:59
       // mTimer.schedule(mTimerTask, today.getTime(), TimeUnit.MILLISECONDS.convert(1,TimeUnit.DAYS));




    }

}
