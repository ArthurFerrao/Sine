package com.example.ferro.listsine.asyncTask;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.example.ferro.listsine.entity.Sine;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ferrão on 29/10/2016.
 */
public class ListAsy extends AsyncTask< String, Void, List<Sine>> {

    @Override
    protected List<Sine> doInBackground(String... strings) {
        String urlString = strings[0];
        List<Sine> sine = new ArrayList<>();

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
        } finally {
            return sine;
        }
    }
    public List<Sine> getSines(JsonReader reader) throws IOException {
        List<Sine> sines = new ArrayList<Sine>();
        reader.beginArray();

        while (reader.hasNext()) {
            sines.add(getSine(reader));
        }

        reader.endArray();
        return sines;
    }
    public Sine getSine(JsonReader reader) throws IOException {
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
        return new Sine(codPosto, nome, entidadeConveniada,  endereco,  bairro,  cep,  telefone,  municipio,  uf,  lat, lon);
    }
    @Override
    protected void onPostExecute(List<Sine> result){
        super.onPostExecute(result);
    }

}
