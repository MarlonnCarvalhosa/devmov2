package com.powellapps.bancodedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.powellapps.bancodedados.bancodedados.BancoDeDados;
import com.powellapps.bancodedados.model.Banda;

public class NovoActivity extends AppCompatActivity {

    //Declara as variaveis
    private EditText editTextNome;
    private EditText editTextGenero;
    private Button buttonSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);
        //Liga o xml com nosso código java
        editTextGenero = (EditText) findViewById(R.id.edit_genero);
        editTextNome = (EditText) findViewById(R.id.edit_nome);
        buttonSalvar = (Button) findViewById(R.id.button_salvar);


        buttonSalvar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Toast é uma mensagem temporaria
         //       Toast.makeText(getApplicationContext(),"Guedes gosta de leite", Toast.LENGTH_LONG).show();
                //AlertDialog pode colocar botoes
                //PopupMenu
                //Dialog

                return true;
            }
        });
        //Implementa o click do botao salvar
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cria um novo objeto banda
                Banda banda = new Banda();
                banda.setNome(editTextNome.getText().toString());
                banda.setGenero(editTextGenero.getText().toString());
                new BancoDeDados(NovoActivity.this).salva(banda);
                finish();

            }
        });
    }
}
