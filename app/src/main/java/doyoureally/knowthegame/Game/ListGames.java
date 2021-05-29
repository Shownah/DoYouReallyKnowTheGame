package doyoureally.knowthegame.Game;

import java.util.ArrayList;

import doyoureally.knowthegame.R.mipmap;

public class ListGames {

    ArrayList<Game> listG;

    public ListGames() {
        this.listG = new ArrayList<>();
    }

    public int size() {
        return listG.size();
    }

    public Game getGame(int pos){
        return listG.get(pos);
    }

    public void construireListGames() {
        listG.add(new Game("GTFO", mipmap.gtfo));
        listG.add(new Game("League of Legends", mipmap.lol));
        listG.add(new Game("Super Smash Bros. Ultimate", mipmap.smash));
        listG.add(new Game("Echecs", mipmap.chess));
    }
}
