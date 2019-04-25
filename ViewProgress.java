package com.example.summerstafford.trashapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.*;
import com.jjoe64.graphview.*;
import android.content.*;


import java.util.ArrayList;

public class ViewProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_progress);

        /*REFERENCE LISTVIEW
        ListView listView = findViewById(R.id.list);

        //CREATE ARRAYLIST FOR CATEGORIES
        final ArrayList<Graph> analysisList = new ArrayList<>();


        Runnable r = new Runnable() {
            @Override
            public void run() {

                //FILL ARRAYLIST WITH CATEGORIES
                analysisList.add(new Graph("Plastic Usage by Category", "Analysis for the " +
                        "week of April 12 - April 19th by Category. Click on graph for recommended products.", R.drawable.graph1));

            }
        };
        r.run();*/

        //GraphView graph = findViewById(R.id.graph);



        /*DataPoint[] data = new DataPoint[analysisList.get(0).data.size()];
        for(int i = 0; i < analysisList.get(0).data.size(); i++){
            DataPoint temp = new DataPoint(analysisList.get(0).data.get(i)[0], analysisList.get(0).data.get(i)[1]);
            data[i] = temp;
        }*/

        //LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(data);
        //graph.addSeries(series);



        //GraphAdapter graphAdapter = new GraphAdapter(this, analysisList);

        //listView.setAdapter(graphAdapter);




    }

    public void goBrowse(View view){
        Intent intent = new Intent(ViewProgress.this, Browse.class);
        startActivity(intent);
    }
}

