package com.example.summerstafford.trashapplication;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import android.app.Activity;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<Category>{

    public CategoryAdapter(Activity context, ArrayList<Category> categoryList){
        super(context,0, categoryList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Category currentCat = getItem(position);
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.category, parent, false);
        }
        TextView catName = (TextView) listItemView.findViewById(R.id.name);
        catName.setText(currentCat.name);

        listItemView.setContentDescription(currentCat.classID);

        ImageView imgName = (ImageView) listItemView.findViewById(R.id.image);

        if(currentCat.imageID == 0){
            imgName.setVisibility(View.INVISIBLE);
        }

        else{
            imgName.setImageResource(currentCat.imageID);
        }

        return listItemView;
    }
}
