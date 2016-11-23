package com.powellapps.ws;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by raphaelramos on 13/10/16.
 */

public class SetupService {

    private static String API_URL = "https://viacep.com.br/ws/";

    public static EnderecoREST get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EnderecoREST rest = retrofit.create(EnderecoREST.class);
        return rest;
    }

    public interface EnderecoREST {
        @GET("{cep}/json")
        Call<Endereco> getEndereco(
                @Path("cep") String cep);
    }

}
