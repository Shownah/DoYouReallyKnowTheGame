package doyoureally.knowthegame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import doyoureally.knowthegame.game.Game;
import doyoureally.knowthegame.quiz.Quiz;
import doyoureally.knowthegame.utils.Utils;


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

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "quiz.json");
        Gson gson = new Gson();
        Type listQuizType = new TypeToken<List<Quiz>>() { }.getType();
        List<Quiz> quizzes = gson.fromJson(jsonFileString, listQuizType);
        System.out.println("YOLO");

        Button button = findViewById(R.id.launch);
        Intent intent = new Intent(ResultGame.this, QuizQuestion.class);
        System.out.println("azeazeaze " + game.toString());
        System.out.println("azeazeaze " + quizzes.get(0).getName());
        button.setOnClickListener((id) -> {
            Quiz quiz = quizzes.stream()
                    .filter(q -> game.getName().equals(q.getName()))
                    .findAny()
                    .orElse(null);
            intent.putExtra("Game", (Parcelable) game);
            intent.putExtra("Quiz", (Parcelable) quiz);
            startActivity(intent);
        });
    }
}
