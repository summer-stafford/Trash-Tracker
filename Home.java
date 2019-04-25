package com.example.summerstafford.trashapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void logWaste(View view){
        Intent intent = new Intent(Home.this, LogInteractions.class);
        startActivity(intent);
    }

    public void viewProgress(View view){
        Intent intent = new Intent(Home.this, ViewProgress.class);
        startActivity(intent);
    }

    public void browse(View view){
        Intent intent = new Intent(Home.this, Browse.class);
        startActivity(intent);
    }

    public void learn(View view){
        Intent intent = new Intent(Home.this, Learn.class);
        startActivity(intent);
    }
}
