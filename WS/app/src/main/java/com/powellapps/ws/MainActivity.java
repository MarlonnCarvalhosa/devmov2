package com.powellapps.ws;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textViewEndereco = (TextView) findViewById(R.id.text_result);
        SetupService.get().getEndereco("28300000").enqueue(new Callback<Endereco>() {
            @Override
            public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                Endereco endereco = response.body();
                textViewEndereco.setText("Endereço " + endereco);
            }

            @Override
            public void onFailure(Call<Endereco> call, Throwable t) {

            }
        });

    }
}
