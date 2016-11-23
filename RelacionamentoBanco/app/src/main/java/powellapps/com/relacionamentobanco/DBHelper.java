package powellapps.com.relacionamentobanco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by raphael on 23/11/16.
 */
public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context) {
        super(context, BancoConstants.BANDA, null, BancoConstants.VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BancoConstants.CRIA_TABELA_BANDA);
        db.execSQL(BancoConstants.CRIA_TABELA_MUSICO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
