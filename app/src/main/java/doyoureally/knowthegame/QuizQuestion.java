package doyoureally.knowthegame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import doyoureally.knowthegame.game.Game;
import doyoureally.knowthegame.quiz.Quiz;

public class QuizQuestion extends AppCompatActivity implements View.OnClickListener {
    private final Button[] answers = new Button[4];
    private final int[] answer_id = {R.id.answer_0, R.id.answer_1, R.id.answer_2, R.id.answer_3};
    private boolean clicked = false;
    private Quiz quiz;
    private Game game;
    private int score;
    private int questionNumber;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        quiz = getIntent().getExtras().getParcelable("Quiz");
        game = getIntent().getExtras().getParcelable("Game");
        score = getIntent().getIntExtra("Score", 0);
        questionNumber = getIntent().getIntExtra("QuestionNumber", 0);

        TextView scoreText = findViewById(R.id.score);
        scoreText.setText("Score : " + score + " / " + questionNumber);

        ImageView gameImage = findViewById(R.id.game_picture);
        gameImage.setImageResource(game.getPicture());

        TextView question = findViewById(R.id.question);
        question.setText(quiz.getQuestions().get(questionNumber).getQuestion());

        for (int i = 0; i < answers.length; i++) {
            MaterialButton temp = findViewById(answer_id[i]);
            answers[i] = temp;
            answers[i].setOnClickListener(this);

            answers[i].setTextColor(Color.rgb(49, 50, 51));
            answers[i].setBackgroundColor(Color.rgb(207, 207, 207));
            answers[i].setText(quiz.getQuestions().get(questionNumber).getAnswers().get(i));
        }
    }

    @Override
    public void onClick(View v) {
        if (clicked) {
            if (questionNumber == quiz.getQuestions().size() - 1) {
                intent = new Intent(QuizQuestion.this, QuizResult.class);
            } else {
                intent = new Intent(QuizQuestion.this, QuizQuestion.class);
            }
            questionNumber++;
            intent.putExtra("Game", (Parcelable) game);
            intent.putExtra("Quiz", (Parcelable) quiz);
            intent.putExtra("Score", (int) score);
            intent.putExtra("QuestionNumber", (int) questionNumber);
            startActivity(intent);
        } else if (v instanceof Button) {
            int index = find(answers, v);
            int answer_i = quiz.getQuestions().get(questionNumber).getRightAnswer();
            if (index >= 0) {
                if (index == answer_i) {
                    v.setBackgroundColor(Color.rgb(25, 100, 25));
                    ((Button) v).setTextColor(Color.rgb(255, 255, 255));
                    score++;
                } else {
                    v.setBackgroundColor(Color.rgb(200, 50, 50));
                    ((Button) v).setTextColor(Color.rgb(255, 255, 255));
                    answers[answer_i].setBackgroundColor(Color.rgb(200, 255, 200));
                }
                clicked = true;
            }
        }
    }

    private int find(Button[] btns, View btn) {
        for (int i = 0; i < btns.length; i++) {
            int id = btn.getId();
            int id2 = btns[i].getId();
            if (btns[i].getId() == btn.getId())
                return i;
        }
        return -1;
    }
}
