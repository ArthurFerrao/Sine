package com.example.ferro.listsine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.concurrent.ExecutionException;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.list);
        ListAsy listSine = new ListAsy();

        try {
            ArrayAdapter<Sine> adapter = new ArrayAdapter<Sine>(this, android.R.layout.simple_list_item_1, listSine.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/").get());
            list.setAdapter(adapter);

        } catch (InterruptedException|ExecutionException e){
            e.printStackTrace();
        }
    }

}
