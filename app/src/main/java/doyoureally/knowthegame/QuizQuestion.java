package doyoureally.knowthegame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import doyoureally.knowthegame.quiz.Quiz;

public class QuizQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        Quiz quiz = getIntent().getExtras().getParcelable("Quiz");

        System.out.println("azeazeaze" + quiz);
    }
}
