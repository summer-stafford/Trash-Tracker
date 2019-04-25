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

public class Bathroom extends AppCompatActivity{

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
                itemList.add(new WasteItem("Hair tie"));
                itemList.add(new WasteItem("Plastic hair brush"));
                itemList.add(new WasteItem("Loofa"));
                itemList.add(new WasteItem("Plastic comb"));
                itemList.add(new WasteItem("Hair product containers"));
                itemList.add(new WasteItem("Lotion bottle"));
                itemList.add(new WasteItem("Pad/ pad packaging"));
                itemList.add(new WasteItem("Tampon/ tampon packaging"));
                itemList.add(new WasteItem("Disposable wipes"));
                itemList.add(new WasteItem("Plastic toothbrush"));
                itemList.add(new WasteItem("Plastic toothpaste tube"));
                itemList.add(new WasteItem("Floss/ floss container"));
                itemList.add(new WasteItem("Face wash bottle"));
                itemList.add(new WasteItem("Shampoo bottle"));
                itemList.add(new WasteItem("Conditioner bottle"));
                itemList.add(new WasteItem("Soap bottle"));
                itemList.add(new WasteItem("Plastic razor"));
                itemList.add(new WasteItem("Mouthwash container"));
                itemList.add(new WasteItem("Deodorant container"));
                itemList.add(new WasteItem("Sunscreen bottle"));
                itemList.add(new WasteItem("Cotton rounds/ pads/ balls"));

            }
        };
        r.run();



        ItemsAdapter itemsAdapter = new ItemsAdapter(this, itemList);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                final WasteItem currentItem = itemList.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(Bathroom.this);
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
