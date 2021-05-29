package doyoureally.knowthegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import doyoureally.knowthegame.Game.Game;


public class ResultGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_layout);
        Game game = getIntent().getExtras().getParcelable("Game");
        ImageView imageView = findViewById(R.id.game_picture);
        TextView name = findViewById(R.id.game_name);
        imageView.setImageResource(game.getPicture());
        name.setText(game.getName());
    }

}
