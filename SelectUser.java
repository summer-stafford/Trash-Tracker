package com.example.summerstafford.trashapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

public class SelectUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
    }

    public void addNewUser(View view){
        Intent intent = new Intent(SelectUser.this, Home.class);
        startActivity(intent);
    }
}
