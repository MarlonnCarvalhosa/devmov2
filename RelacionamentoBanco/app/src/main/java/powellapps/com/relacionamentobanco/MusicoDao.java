package powellapps.com.relacionamentobanco;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by raphael on 23/11/16.
 */
public class MusicoDao {

    private DBHelper dbHelper;

    public MusicoDao(AppCompatActivity activity) {
        dbHelper = new DBHelper(activity);
    }

    public void salva(Musico musico) {
        dbHelper.getWritableDatabase().insert(BancoConstants.MUSICO,null, musico.getValues());
    }

    public ArrayList<Musico> getMusicos(Integer idBanda) {
        Cursor cursor = dbHelper.getReadableDatabase().query(BancoConstants.MUSICO,null, BancoConstants.MUSICO_ID_BANDA + " = ? ", new String[] {idBanda.toString()}, null,null,null);
        ArrayList<Musico> musicos = new ArrayList<>();
        while (cursor.moveToNext()){
            musicos.add(new Musico(cursor));
        }
        cursor.close();
        return musicos;
    }
}
