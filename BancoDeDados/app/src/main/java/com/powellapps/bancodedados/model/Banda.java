package com.powellapps.bancodedados.model;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by raphael on 04/08/16.
 */
public class Banda {

    private Integer id;
    private String nome;
    private String genero;

    public Banda(Cursor cursorComBandas) {
        setId(cursorComBandas.getInt(cursorComBandas.getColumnIndex("ID")));
        setNome(cursorComBandas.getString(cursorComBandas.getColumnIndex("NOME")));
        setGenero(cursorComBandas.getString(cursorComBandas.getColumnIndex("GENERO")));
    }

    public Banda() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //Método que usaremos na hora de inserir no banco de dados
    public ContentValues getValues() {
        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("NOME", nome);
        values.put("GENERO", genero);
        return values;
    }
}
