package powellapps.com.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    
    private TextView textViewResultado;
    private EditText editTextNumero;
    private Button buttonCalcular;
    private Button buttonCalcularCerto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textViewResultado = (TextView) findViewById(R.id.text_view_resultado);
        buttonCalcular = (Button) findViewById(R.id.button_calcula);
        editTextNumero = (EditText) findViewById(R.id.edit_text_numero);
        buttonCalcularCerto = (Button) findViewById(R.id.button_calcula_certo);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigInteger resultado = fibonacci(Integer.valueOf(editTextNumero.getText().toString()));
                textViewResultado.setText("Resultado = " + resultado.toString());
            }
        });

        buttonCalcularCerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncCalculo().execute();
            }
        });
    }

    //Método que irá demorar. Poderia ser uma conexão com banco de dados, acesso a um web service, etc
    private BigInteger fibonacci(int numero){
        BigInteger resultado = BigInteger.ONE;
        for(Integer i=2;i<=numero;i++){
            resultado = resultado.add(new BigInteger(i.toString()));
        }
        Log.v("Fibonacci", "Resultado " + resultado);
        return resultado;
    }

    //Método que rodará em background
    private class AsyncCalculo extends AsyncTask<Void, Void, Void>{

        Integer numero;
        private BigInteger resultado;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            numero = Integer.valueOf(editTextNumero.getText().toString());
        }

        @Override
        protected Void doInBackground(Void... params) {
            resultado = fibonacci(numero);
            Log.v("Fibonacci", "Resultado " + resultado);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textViewResultado.setText("Resultado = " + resultado.toString());
        }

    }
}
