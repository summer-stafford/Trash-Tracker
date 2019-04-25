package com.example.summerstafford.trashapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.net.Uri;
import android.content.Intent;
import java.util.ArrayList;

public class Browse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        //REFERENCE LISTVIEW
        ListView listView = findViewById(R.id.listView);

        //CREATE ARRAYLIST FOR CATEGORIES
        final ArrayList<Product> productList = new ArrayList<>();




        Runnable r = new Runnable() {
            @Override
            public void run() {

                //FILL ARRAYLIST WITH PRODUCTS
                productList.add(new Product("Deodorant", "Meow Meow Tweet", R.drawable.bsdeo,
                        getString(R.string.deodorant)));
                productList.add(new Product("Face soap", "Meow Meow Tweet", R.drawable.ttface,
                        getString(R.string.face_soap)));
                productList.add(new Product("Bamboo Toothbrush", "Brush with Bamboo", R.drawable.bbtooth,
                        getString(R.string.toothbrush)));
                productList.add(new Product("Sunscreen", "Raw Elements", R.drawable.sunscreen,
                        getString(R.string.sunscreen)));
                productList.add(new Product("Water Bottle Brush", "Package Free Shop", R.drawable.wb_brush,
                        getString(R.string.wbBrush)));
                productList.add(new Product("Beeswax Wraps", "Package Free Shop", R.drawable.beeswax,
                        getString(R.string.beeswaxWrap)));





            }
        };
        r.run();



        ProductAdapter mProductAdapter = new ProductAdapter(this, productList);

        listView.setAdapter(mProductAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product currentP = productList.get(position);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(currentP.url));
                startActivity(intent);
            }
        });
    }
}
