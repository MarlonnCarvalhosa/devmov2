package powellapps.com.relacionamentobanco;

import android.content.ContentValues;
import android.database.Cursor;
import android.webkit.ConsoleMessage;

/**
 * Created by raphael on 23/11/16.
 */
public class Musico {

    private Integer id;
    private String nome;
    private Integer idBanda;

    public Musico(Cursor cursor) {
        setNome(cursor.getString(cursor.getColumnIndex(BancoConstants.MUSICO_NOME)));
        setIdBanda(cursor.getInt(cursor.getColumnIndex(BancoConstants.MUSICO_ID_BANDA)));
        setId(cursor.getInt(cursor.getColumnIndex(BancoConstants.MUSICO_ID)));
    }

    public Musico() {

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

    public Integer getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(Integer idBanda) {
        this.idBanda = idBanda;
    }

    public ContentValues getValues() {
        ContentValues values = new ContentValues();
        values.put(BancoConstants.MUSICO_ID_BANDA, idBanda);
        values.put(BancoConstants.MUSICO_NOME, nome);
        return values;
    }
}
