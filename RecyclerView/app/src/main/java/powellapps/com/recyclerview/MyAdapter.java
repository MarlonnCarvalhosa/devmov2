package powellapps.com.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by raphael on 06/10/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CursoViewHolder> {
    private ArrayList<Curso> cursos;
    private Context context;

    public MyAdapter(ArrayList<Curso> cursos, Context context) {
        this.cursos = cursos;
        this.context = context;
    }

    @Override
    public CursoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Método obrigatório que infla o xml do adapter e instancia o view holder
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_curso, parent, false);
        return new CursoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CursoViewHolder holder, final int position) {
        //Método obrigatório, atribui cada objeto da lista ao viewholder
        final Curso curso = cursos.get(position);
        holder.textViewValor.setText(curso.getValor());
        holder.textViewNome.setText(curso.getNome());
        holder.textViewCursar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Giovani 'é gazela " + position + curso.getNome(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }

    //Criar o view holder obrigatoriamente. Aqui você atribui os views do adapter.
    public class CursoViewHolder extends RecyclerView.ViewHolder{

    private TextView textViewNome;
    private TextView textViewValor;
        private TextView textViewCursar;

        public CursoViewHolder(View itemView) {
            super(itemView);
            textViewNome = (TextView) itemView.findViewById(R.id.text_nome);
            textViewValor = (TextView) itemView.findViewById(R.id.text_valor);
            textViewCursar = (TextView) itemView.findViewById(R.id.text_cursar);
        }
    }
}
