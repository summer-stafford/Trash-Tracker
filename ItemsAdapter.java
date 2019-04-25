package com.example.summerstafford.trashapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<WasteItem> {

    public ItemsAdapter(Activity context, ArrayList<WasteItem> itemList){
        super(context,0, itemList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        WasteItem currentItem = getItem(position);
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.waste_item, parent, false);
        }
        TextView itemName = listItemView.findViewById(R.id.itemName);
        itemName.setText(currentItem.name);

        TextView interactTotal = listItemView.findViewById(R.id.interactTotal);
        interactTotal.setText(Integer.toString(currentItem.interactTotal));

        TextView wasteTotal = listItemView.findViewById(R.id.wasteTotal);
        wasteTotal.setText(Integer.toString(currentItem.wasteTotal));


        return listItemView;
    }
}
