package powellapps.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Curso> cursos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Conecta a view do xml ao código java
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //Padrão de lista para um recycler view
        mLayoutManager = new LinearLayoutManager(this);
        //Atribui o padrão ao recycler
        mRecyclerView.setLayoutManager(mLayoutManager);
        criaCursosParaDemonstracao();
        //Cria o adapter
        mAdapter = new MyAdapter(cursos);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void criaCursosParaDemonstracao() {
        Curso sistemas = new Curso();
        sistemas.setNome("Sistemas de informação");
        sistemas.setValor("R$ 500,00");

        Curso biologia = new Curso();
        biologia.setNome("Biologia");
        biologia.setValor("R$ 300,00");

        Curso civil = new Curso();
        civil.setNome("Engenharia civil");
        civil.setValor("R$ 600, 00");

        Curso direito = new Curso();
        direito.setNome("Direito");
        direito.setValor("R$ 1000,00");
        cursos.add(sistemas);
        cursos.add(direito);
        cursos.add(biologia);
        cursos.add(civil);

    }


}
