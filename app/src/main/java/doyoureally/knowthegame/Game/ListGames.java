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
        // listG.add(new Game("Monster Hunter Rise", mipmap.mhr));
        // listG.add(new Game("Biomutant", mipmap.biomutant));
        listG.add(new Game("GTA V", mipmap.gta));
        // listG.add(new Game("The Binding of Isaac", mipmap.isaac));
        // listG.add(new Game("Pummel Party", mipmap.pummel_party));
        // listG.add(new Game("Resident Evil Village", mipmap.re_village));
        listG.add(new Game("Sea Of Thieves", mipmap.sot));
    }
}
