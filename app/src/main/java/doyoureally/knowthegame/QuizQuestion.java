package doyoureally.knowthegame;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import doyoureally.knowthegame.Game.Game;
import doyoureally.knowthegame.Quiz.Quiz;

public class QuizQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        Quiz quiz = getIntent().getExtras().getParcelable("Quiz");

    }
}
