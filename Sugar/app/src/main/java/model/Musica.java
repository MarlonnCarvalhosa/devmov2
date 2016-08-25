package model;

import com.orm.SugarRecord;

/**
 * Created by raphael on 25/08/16.
 */
public class Musica extends SugarRecord {

    String nome;
    String banda;

    public Musica() {}

    public Musica(String nome, String banda) {
        this.nome = nome;
        this.banda = banda;
    }
}
