package doyoureally.knowthegame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import doyoureally.knowthegame.game.Game;
import doyoureally.knowthegame.quiz.Quiz;

public class QuizResult extends AppCompatActivity {
    private Quiz quiz;
    private Game game;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        quiz = getIntent().getExtras().getParcelable("Quiz");
        game = getIntent().getExtras().getParcelable("Game");
        score = getIntent().getIntExtra("Score", 0);

        TextView result = findViewById(R.id.results);
        result.setText("Le score final est de " + score + " / " + quiz.getQuestions().size());

        ImageView img = findViewById(R.id.game_picture);
        img.setImageResource(game.getPicture());

        Button menu = findViewById(R.id.menu);
        menu.setOnClickListener((click) -> {
            Intent intent = new Intent(QuizResult.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
