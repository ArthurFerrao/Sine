package com.example.ferro.listsine.activity;

import android.app.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.ferro.listsine.R;

public class MainActivity extends AppCompatActivity {

    private Button btnListAll;
    private Button btnListCg;
    private Button btnMapsCg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListAll = (Button) findViewById(R.id.btnListAll);
        btnListCg = (Button) findViewById(R.id.btnListCg);
        btnMapsCg = (Button) findViewById(R.id.btnMapsCg);


    }

    public void goListAll(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void goListCg(View view){
        Intent intent = new Intent(this, ListCgActivity.class);
        startActivity(intent);
    }

    public void goMapsCg(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
