package com.example.ferro.listsine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ferro.listsine.R;
import com.example.ferro.listsine.asyncTask.ListAsy;
import com.example.ferro.listsine.asyncTask.ListAsyDet;
import com.example.ferro.listsine.entity.Sine;
import com.example.ferro.listsine.entity.SineDet;

import java.util.concurrent.ExecutionException;

public class ListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.list);
        ListAsy listSine = new ListAsy();

        try {
            final ArrayAdapter<Sine> adapter = new ArrayAdapter<Sine>(this, android.R.layout.simple_list_item_1, listSine.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/").get());
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String codPost = (String) adapter.getItem(position).getCodPosto();
                    ListView listDet = (ListView) findViewById(R.id.list);
                    ListAsyDet listSineDet = new ListAsyDet();
                    try {
                        ArrayAdapter<SineDet> adapter = new ArrayAdapter<SineDet>(view.getContext(), android.R.layout.simple_list_item_1, listSineDet.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/cod/" + codPost).get());
                        listDet.setAdapter(adapter);

                    } catch (InterruptedException|ExecutionException e){
                        e.printStackTrace();
                    }
                }
            });
        } catch (InterruptedException|ExecutionException e){
            e.printStackTrace();
        }

    }


}
