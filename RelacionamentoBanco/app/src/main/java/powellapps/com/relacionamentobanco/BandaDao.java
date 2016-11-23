package powellapps.com.relacionamentobanco;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by raphael on 23/11/16.
 */
public class BandaDao {

    private DBHelper dbHelper;

    public BandaDao(AppCompatActivity activity) {
        dbHelper = new DBHelper(activity);
    }

    public void salva(Banda banda) {
        dbHelper.getWritableDatabase().insert(BancoConstants.BANDA,null,banda.getValues());
    }

    public ArrayList<Banda> getBandas() {
        Cursor cursor = dbHelper.getReadableDatabase().query(BancoConstants.BANDA,null,null,null,null,null,null);
        ArrayList<Banda> bandas = new ArrayList<>();
        while (cursor.moveToNext()){
            bandas.add(new Banda(cursor));
        }
        cursor.close();
        return bandas;
    }
}
