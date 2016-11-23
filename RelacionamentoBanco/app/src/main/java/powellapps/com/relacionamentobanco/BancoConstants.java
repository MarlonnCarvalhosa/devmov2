package powellapps.com.relacionamentobanco;

/**
 * Created by raphael on 23/11/16.
 */
public class BancoConstants {
    public static final String BANDA = "BANDA";
    public static final int VERSAO = 1;
    public static final String BANDA_NOME = "nome";
    public static final String BANDA_ID = "id";
    public static final String CRIA_TABELA_BANDA = "CREATE TABLE " + BANDA + " (" + BANDA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BANDA_NOME +
            " TEXT)";
    public static final String MUSICO = "MUSICO";
    public static final String MUSICO_NOME = "nome";
    public static final String MUSICO_ID = "id";
    public static final String MUSICO_ID_BANDA = "id_banda";
    public static final String CRIA_TABELA_MUSICO = "CREATE TABLE " + MUSICO +
            " (" + MUSICO_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + MUSICO_NOME +
            " TEXT, " + MUSICO_ID_BANDA +
            " INTEGER)";
}
