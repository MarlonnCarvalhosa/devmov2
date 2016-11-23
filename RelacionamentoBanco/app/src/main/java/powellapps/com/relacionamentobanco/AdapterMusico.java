package powellapps.com.relacionamentobanco;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raphael on 23/11/16.
 */
public class AdapterMusico extends ArrayAdapter<Musico>{


    public AdapterMusico(AppCompatActivity activity, ArrayList<Musico> musicos) {
        super(activity, R.layout.activity_musicos,musicos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        MusicoViewHolder musicoViewHolder;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.adapter,parent, false);
            musicoViewHolder = new MusicoViewHolder(view);
            view.setTag(musicoViewHolder);
        }else{
            musicoViewHolder = (MusicoViewHolder) view.getTag();
        }

        Musico musico = getItem(position);
        musicoViewHolder.textViewNome.setText(musico.getNome());
        return view;
    }

    public void atualiza(ArrayList<Musico> musicos) {
        clear();
        addAll(musicos);
        notifyDataSetChanged();
    }

    public class MusicoViewHolder{

        private TextView textViewNome;

        public MusicoViewHolder(View view){
            textViewNome = (TextView) view.findViewById(R.id.text_nome);
        }
    }
}
