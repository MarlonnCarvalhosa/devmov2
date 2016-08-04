package com.powellapps.bancodedados.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.powellapps.bancodedados.R;
import com.powellapps.bancodedados.model.Banda;

import java.util.ArrayList;

/**
 * Created by raphael on 04/08/16.
 */
public class BandaAdapter extends ArrayAdapter<Banda> {

    ArrayList<Banda> bandas;

    public BandaAdapter(Context context, ArrayList<Banda> bandas) {
        super(context, R.layout.activity_lista, bandas);
        this.bandas = bandas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Recupera cada banda na lista pela posição
        Banda banda = getItem(position);
        //Verifica se é uma view nova ou pode ser reutilizável
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_banda, parent, false);
        }

        //Liga o xml adapter_banda ao arrayadapter
        TextView textNome = (TextView) convertView.findViewById(R.id.text_nome);
        TextView textGenero = (TextView) convertView.findViewById(R.id.text_genero);

        //Popula o layout do adapter_banda com o nome da banda e genero
        textNome.setText(banda.getNome());
        textGenero.setText(banda.getGenero());
        // Retorna a view
        return convertView;
    }

    public void atualiza(ArrayList<Banda> bandas) {
        this.bandas.clear();
        this.bandas.addAll(bandas);
        notifyDataSetChanged();
    }
}
