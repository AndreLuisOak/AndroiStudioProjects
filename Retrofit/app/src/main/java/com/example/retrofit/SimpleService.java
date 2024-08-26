package com.example.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import java.util.List;
import java.io.IOException;


public class SimpleService {
    private static final String API_URL = "https://servicodados.ibge.gov.br/";

    interface Api {
        @GET("api/v1/localidades/distritos")
        Call<List<Distrito>> distritos();
    }

    public void doRequest() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);

        Call<List<Distrito>> call = api.distritos();
        List<Distrito> distritos = call.execute().body();

        for (Distrito distrito : distritos) {
            System.out.println("Distrito ID: " + distrito.id + ", Nome: " + distrito.nome);
        }
    }
}