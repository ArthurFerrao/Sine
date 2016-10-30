package com.example.ferro.listsine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ferro.listsine.R;
import com.example.ferro.listsine.asyncTask.ListAsy;
import com.example.ferro.listsine.entity.Sine;

import java.util.concurrent.ExecutionException;

/**
 * Created by Thayanne on 10/29/2016.
 */
public class ListCgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cg);

        ListView list = (ListView) findViewById(R.id.list);
        ListAsy listSine = new ListAsy();

        try {
            ArrayAdapter<Sine> adapter = new ArrayAdapter<Sine>(this, android.R.layout.simple_list_item_1,
                    listSine.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/latitude/-7.242662/longitude/-35.9716057/raio/100").get());
            list.setAdapter(adapter);

        } catch (InterruptedException|ExecutionException e){
            e.printStackTrace();
        }
    }
}
