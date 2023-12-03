package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        URL urlObj = new URL("https://api.publicapis.org/entries");
        HttpURLConnection conexao = (HttpURLConnection)urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int resposta = conexao.getResponseCode();

        if(resposta == HttpURLConnection.HTTP_OK)
        {
            BufferedReader receber = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            String leitura;
            StringBuffer respons = new StringBuffer();

            while((leitura = receber.readLine()) != null)
            {
                respons.append(leitura);
            }
            receber.close();

            JSONObject json  = new JSONObject(respons.toString());
            JSONArray jArray = json.getJSONArray("entries");
            int counter = 0;

            for(int c = 0; c<jArray.length();c++) {

                JSONObject jsonObject = jArray.getJSONObject(c);

                Resposta answer = new Resposta(jsonObject.toString());

                System.out.println(answer);
            }
        } else
        {
            System.out.println("API Indisponivel no momento");
        }



    }
}