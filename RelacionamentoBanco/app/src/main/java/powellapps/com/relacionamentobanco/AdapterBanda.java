package powellapps.com.relacionamentobanco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raphael on 23/11/16.
 */
public class AdapterBanda extends ArrayAdapter<Banda>{

  //  private ArrayList<Banda> bandas;

    public AdapterBanda(Context context, ArrayList<Banda> bandas) {
        super(context, R.layout.activity_main, bandas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        BandaViewHolder bandaViewHolder;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.adapter, parent, false);
            bandaViewHolder = new BandaViewHolder(view);
            view.setTag(bandaViewHolder);
        }else{
            bandaViewHolder = (BandaViewHolder) view.getTag();
        }

        Banda banda = getItem(position);
        bandaViewHolder.textViewNome.setText(banda.getNome());
        return view;
    }

    public void atualiza(ArrayList<Banda> bandas) {
        clear();
        addAll(bandas);
        notifyDataSetChanged();
    }

    public class BandaViewHolder {
        TextView textViewNome;

        public BandaViewHolder(View view) {
            textViewNome = (TextView) view.findViewById(R.id.text_nome);
        }
    }
}
