package com.example.ferro.listsine.asyncTask;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.example.ferro.listsine.entity.SineDet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALemos on 29/10/2016.
 */
public class ListAsyDet extends AsyncTask< String, Void, List<SineDet>> {

    @Override
    protected List<SineDet> doInBackground(String... strings) {
        String urlString = strings[0];
        List<SineDet> sine = new ArrayList<>();

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            InputStream instream = connection.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(instream, "UTF-8"));

            sine = getSines(reader);

            instream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
            Log.e("Erro", "Falha ao acessar Web service", ex);
        }

        return sine;
    }
    public List<SineDet> getSines(JsonReader reader) throws IOException {
        List<SineDet> sines = new ArrayList<SineDet>();
        reader.beginArray();

        while (reader.hasNext()) {
            sines.add(getSine(reader));
        }

        reader.endArray();
        return sines;
    }
    public SineDet getSine(JsonReader reader) throws IOException {
        String codPosto="",nome = "",entidadeConveniada = "",endereco="",bairro="",cep="",telefone="",municipio="",uf="",lat="",lon="";
        reader.beginObject();

        while (reader.hasNext()) {
            String obj = reader.nextName();
            if (obj.equals("codPosto")) {
                codPosto = reader.nextString();

            } else if (obj.equals("nome")) {
                nome = reader.nextString();

            } else if (obj.equals("entidadeConveniada")) {
                entidadeConveniada = reader.nextString();

            } else if (obj.equals("endereco")) {
                endereco = reader.nextString();

            } else if (obj.equals("bairro")) {
                bairro = reader.nextString();

            } else if (obj.equals("cep")) {
                cep = reader.nextString();

            } else if (obj.equals("telefone")) {
                telefone = reader.nextString();

            } else if (obj.equals("municipio")) {
                municipio = reader.nextString();

            } else if (obj.equals("uf")) {
                uf = reader.nextString();

            } else if (obj.equals("lat")) {
                lat = reader.nextString();

            } else if (obj.equals("long")) {
                lon = reader.nextString();

            }else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new SineDet(codPosto, nome, entidadeConveniada,  endereco,  bairro,  cep,  telefone,  municipio,  uf,  lat, lon);
    }
    @Override
    protected void onPostExecute(List<SineDet> result){
        super.onPostExecute(result);
    }

}