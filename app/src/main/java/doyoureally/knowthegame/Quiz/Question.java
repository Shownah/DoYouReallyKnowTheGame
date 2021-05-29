package doyoureally.knowthegame.Quiz;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> answers = new ArrayList<>();
    private int rightAnswer;

    public Question(String question, ArrayList<String> answers, int rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }
}
