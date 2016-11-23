package powellapps.com.relacionamentobanco;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by raphael on 23/11/16.
 */
public class Banda {

    private Integer id;
    private String nome;

    public Banda(Cursor cursor) {
        setNome(cursor.getString(cursor.getColumnIndex(BancoConstants.BANDA_NOME)));
        setId(cursor.getInt(cursor.getColumnIndex(BancoConstants.BANDA_ID)));
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

    public ContentValues getValues() {
        ContentValues values = new ContentValues();
        values.put(BancoConstants.BANDA_NOME, nome);
        return values;
    }
}
