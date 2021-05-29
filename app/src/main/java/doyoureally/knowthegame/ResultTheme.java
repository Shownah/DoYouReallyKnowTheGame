package doyoureally.knowthegame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import doyoureally.knowthegame.game.Game;


public class ResultTheme extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_layout);
        Game game = getIntent().getExtras().getParcelable("Theme");
        ImageView imageView = findViewById(R.id.theme_picture);
        TextView name = findViewById(R.id.theme_name);
        imageView.setImageResource(game.getPicture());
        name.setText(game.getName());
    }

}
