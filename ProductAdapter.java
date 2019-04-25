package com.example.summerstafford.trashapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(Activity context, ArrayList<Product> pList){
        super(context,0, pList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Product currentItem = getItem(position);
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.product, parent, false);
        }
        TextView prodName = listItemView.findViewById(R.id.productName);
        prodName.setText(currentItem.productName);

        TextView company = listItemView.findViewById(R.id.company);
        company.setText(currentItem.company);

        ImageView image = listItemView.findViewById(R.id.productImage);
        image.setImageResource(currentItem.imgId);


        return listItemView;
    }
}
