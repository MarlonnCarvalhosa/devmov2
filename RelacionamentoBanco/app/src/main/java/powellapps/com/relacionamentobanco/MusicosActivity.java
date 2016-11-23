package powellapps.com.relacionamentobanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicosActivity extends AppCompatActivity {

    private ListView listViewMusicos;
    private Button buttonSalvar;
    private EditText editTextMusico;
    private MusicoDao musicoDao;
    private AdapterMusico adapterMusico;
    private ArrayList<Musico> musicos;
    private Integer idBanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicos);

        atribuiViewById();
        musicoDao = new MusicoDao(this);
        musicos = new ArrayList<>();
        adapterMusico = new AdapterMusico(this, musicos);
        listViewMusicos.setAdapter(adapterMusico);
        idBanda = getIntent().getIntExtra("id", 0);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Musico musico = new Musico();
                musico.setNome(editTextMusico.getText().toString());
                musico.setIdBanda(idBanda);
                musicoDao.salva(musico);
                editTextMusico.setText("");
                atualiza();
            }
        });

        listViewMusicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Musico musico = musicos.get(position);
                Toast.makeText(getApplicationContext(),"Certinho " + musico.getNome() + " com id banda" + musico.getIdBanda(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void atualiza() {
        musicos = musicoDao.getMusicos(idBanda);
        adapterMusico.atualiza(musicos);
    }

    private void atribuiViewById() {
        listViewMusicos = (ListView) findViewById(R.id.list_musicos);
        editTextMusico = (EditText) findViewById(R.id.edit_text_musico);
        buttonSalvar = (Button) findViewById(R.id.button_salvar_musico);

    }

    @Override
    protected void onResume() {
        super.onResume();
        atualiza();
    }
}
