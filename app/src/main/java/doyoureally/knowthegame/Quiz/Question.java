package doyoureally.knowthegame.quiz;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Question implements Parcelable {
    private String question;
    private ArrayList<String> answers;
    private int rightAnswer;

    public Question(String question, ArrayList<String> answers, int rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    protected Question(Parcel in) {
        question = in.readString();
        answers = in.createStringArrayList();
        rightAnswer = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeInt(rightAnswer);
        dest.writeList(answers);
    }
}
