package com.powellapps.bancodedados;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Toolbar é a barra que fica no alto da tela dos aplicativos. Neste momento não será utilizada para nada!
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Botão flutuante que aparece na maioria dos aplicativos novos.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Implementação do click no botão flutuante
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Como o nome da variável diz, aqui é declarado uma intenção de sair da tela ListaActivity
                // e ir para tela de NovoActivity
                Intent intentParaNovoActivity = new Intent(ListaActivity.this, NovoActivity.class);
                //Esse é o método que realiza essa intenção
                startActivity(intentParaNovoActivity);
            }
        });
    }

}
