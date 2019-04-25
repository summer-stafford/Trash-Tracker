package com.example.summerstafford.trashapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Cleaning extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_interactions);


        //REFERENCE LISTVIEW
        ListView listView = findViewById(R.id.list);

        //CREATE ARRAYLIST FOR CATEGORIES
        final ArrayList<WasteItem> itemList = new ArrayList<>();



        Runnable r = new Runnable() {
            @Override
            public void run() {

                //FILL ARRAYLIST WITH CATEGORIES
                itemList.add(new WasteItem("Plastic spray bottle"));
                itemList.add(new WasteItem("Paper towels"));
                itemList.add(new WasteItem("Disposable duster"));
                itemList.add(new WasteItem("Swiffer pad"));
                itemList.add(new WasteItem("Laundry detergent bottle"));
                itemList.add(new WasteItem("Dryer sheet"));
                itemList.add(new WasteItem("Disinfecting wipes"));
                itemList.add(new WasteItem("Sponge"));
                itemList.add(new WasteItem("Plastic soap dispenser"));

            }
        };
        r.run();



        ItemsAdapter itemsAdapter = new ItemsAdapter(this, itemList);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                final WasteItem currentItem = itemList.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(Cleaning.this);
                builder.setTitle("Did this interaction result in waste?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        currentItem.wasteTotal++;
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

                currentItem.interactTotal++;

                TextView currentInteract = view.findViewById(R.id.interactTotal);

                currentInteract.setText(Integer.toString(currentItem.interactTotal));

                TextView currentWaste = view.findViewById(R.id.wasteTotal);

                currentWaste.setText(Integer.toString(currentItem.wasteTotal));



            }
        });
    }
}
