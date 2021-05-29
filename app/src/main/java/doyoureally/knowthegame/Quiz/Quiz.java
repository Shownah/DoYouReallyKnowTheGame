package doyoureally.knowthegame.quiz;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Quiz implements Parcelable {
    private ArrayList<Question> questions;
    private String name;
    private String id;
    private String mipmapName;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Quiz(String gameName) {

    }

    public Quiz(ArrayList<Question> questions, String name, String id, String mipmapName) {
        this.questions = questions;
        this.name = name;
        this.id = id;
        this.mipmapName = mipmapName;
    }

    protected Quiz(Parcel in) {
        name = in.readString();
        id = in.readString();
        mipmapName = in.readString();
        questions = in.createTypedArrayList(Question.CREATOR);
    }

    public static final Creator<Quiz> CREATOR = new Creator<Quiz>() {
        @Override
        public Quiz createFromParcel(Parcel in) {
            return new Quiz(in);
        }

        @Override
        public Quiz[] newArray(int size) {
            return new Quiz[size];
        }
    };

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getMipmapName() {
        return mipmapName;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                //"questions=" + questions +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", mipmapName='" + mipmapName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(questions);
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(mipmapName);
    }
}
