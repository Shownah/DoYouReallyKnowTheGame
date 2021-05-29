package doyoureally.knowthegame.Game;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {

    private String name;
    private int picture;

    public Game(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    protected Game(Parcel in) {
        name = in.readString();
        picture = in.readInt();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture() {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Nom = " + name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(picture);
    }
}
