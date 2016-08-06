package com.powellapps.bancodedados.bancodedados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.powellapps.bancodedados.NovoActivity;
import com.powellapps.bancodedados.model.Banda;

import java.util.ArrayList;

/**
 * Created by raphael on 04/08/16.
 */

//A classe SQLiteOpenHelper que realiza toda magia
public class BancoDeDados extends SQLiteOpenHelper {
    private static final String TABELA_BANDA = "BANDA";

    //Construtor com context, nome do banco de dados, factory que pode ser null e a versão do banco
    public BancoDeDados(Context context) {
        super(context, "banda.db", null, 1);
    }

    public void salva(Banda banda) {
        //Método para inserir
        if(existe()){
            atualiza();
        }else{
            getWritableDatabase().insert(TABELA_BANDA, null, banda.getValues());
        }

    }

    private boolean existe() {
        return false;
    }

    private void atualiza() {
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Comando sql para criacao de uma tabela. Não é indicado usar os nomes sem uma constante, mas usaremos aqui para ficar mais simples
        db.execSQL("CREATE TABLE " + TABELA_BANDA +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT, GENERO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Banda> getBandas() {

        //Criar um array
        ArrayList<Banda> bandas = new ArrayList<>();

        //Retorno um cursor
        Cursor cursorComBandas = getReadableDatabase().query("BANDA",null,null,null,null,null,null);
        while (cursorComBandas.moveToNext()){
            bandas.add(new Banda(cursorComBandas));
        }
        return bandas;
    }
}
