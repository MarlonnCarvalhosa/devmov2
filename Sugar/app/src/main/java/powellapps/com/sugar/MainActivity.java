package powellapps.com.sugar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import model.Musica;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  Musica.findById(Musica.class, 1);

        Musica faroeste = new Musica("Faroeste caboclo", "Legião urbana");
        faroeste.save();
        List<Musica> musics = (List<Musica>) Musica.listAll(Musica.class);
        Log.d("", "Quantidade no banco " + musics.size());
    }
}
