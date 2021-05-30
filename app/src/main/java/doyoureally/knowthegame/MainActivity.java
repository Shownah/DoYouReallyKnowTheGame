package doyoureally.knowthegame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import doyoureally.knowthegame.game.Game;
import doyoureally.knowthegame.game.ListGames;

public class MainActivity extends AppCompatActivity {

    ListGames listG = new ListGames();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listG.construireListGames();
        ListView listView = findViewById(R.id.listView);
        System.out.println(listView);
        Intent intent = new Intent(MainActivity.this, ResultGame.class);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Game game = listG.getGame(position);
            intent.putExtra("Game", (Parcelable) game);
            startActivity(intent);
        });


    }
}
