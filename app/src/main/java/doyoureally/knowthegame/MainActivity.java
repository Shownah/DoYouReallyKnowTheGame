package doyoureally.knowthegame;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import doyoureally.knowthegame.Game.Game;
import doyoureally.knowthegame.Game.ListGames;

public class MainActivity extends AppCompatActivity {

    ListGames listG = new ListGames();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listG.construireListGames();
        ListView listView = findViewById(R.id.listView);
        Intent intent = new Intent(MainActivity.this, ResultGame.class);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Game game = listG.getGame(position);
            intent.putExtra("Game", (Parcelable) game);
            startActivity(intent);
        });
    }
}
