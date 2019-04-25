package com.example.summerstafford.trashapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;

import java.util.ArrayList;
import com.jjoe64.graphview.series.*;

public class GraphAdapter extends ArrayAdapter<Graph> {
    public GraphAdapter(Activity context, ArrayList<Graph> graphList){
        super(context,0, graphList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Graph currentG = getItem(position);
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.category, parent, false);
        }
        TextView graphName = (TextView) listItemView.findViewById(R.id.graphTitle);
        graphName.setText(currentG.title);

        TextView graphCap = listItemView.findViewById(R.id.caption);
        graphCap.setText(currentG.caption);

        ImageView image = listItemView.findViewById(R.id.graphImage);
        image.setImageResource(currentG.imgId);

        /*GraphView graph = listItemView.findViewById(R.id.graph);

        DataPoint[] data = new DataPoint[currentG.data.size()];
        for(int i = 0; i < currentG.data.size(); i++){
            DataPoint temp = new DataPoint(currentG.data.get(i)[0], currentG.data.get(i)[1]);
            data[i] = temp;
        }

        if(currentG.type.equals("Line")){
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(data);
            graph.addSeries(series);
        }*/

        return listItemView;
    }
}
