package powellapps.com.relacionamentobanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewBandas;
    private EditText editTextBanda;
    private Button buttonSalvar;
    private ArrayList<Banda> bandas;
    private BandaDao bandaDao;
    private AdapterBanda adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        atribuiViewById();
        bandaDao = new BandaDao(this);
        adapter= new AdapterBanda(this, new ArrayList<Banda>());
        listViewBandas.setAdapter(adapter);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Banda banda = new Banda();
                banda.setNome(editTextBanda.getText().toString());
                bandaDao.salva(banda);
                editTextBanda.setText("");
                atualiza();
            }
        });

        listViewBandas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Banda banda = bandas.get(position);
                Intent it = new Intent(MainActivity.this, MusicosActivity.class);
                it.putExtra("id", banda.getId());
                startActivity(it);
            }
        });
    }

    private void atualiza() {
        bandas = bandaDao.getBandas();
        adapter.atualiza(bandas);
    }

    private void atribuiViewById() {
        listViewBandas = (ListView) findViewById(R.id.list_bandas);
        editTextBanda = (EditText) findViewById(R.id.edit_text_banda);
        buttonSalvar = (Button) findViewById(R.id.button_salvar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualiza();
    }
}
