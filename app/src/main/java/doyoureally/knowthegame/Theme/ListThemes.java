package doyoureally.knowthegame.Theme;

import java.util.ArrayList;

import doyoureally.knowthegame.R.mipmap;

public class ListThemes {

    ArrayList<Theme> listT;

    public ListThemes() {
        this.listT = new ArrayList<>();
    }

    public int size() {
        return listT.size();
    }

    public Theme getTheme(int pos){
        return listT.get(pos);
    }

    public void construireListThemes() {
        listT.add(new Theme("GTFO", mipmap.gtfo));
        listT.add(new Theme("League of Legends", mipmap.lol));
        listT.add(new Theme("Super Smash Bros. Ultimate", mipmap.smash));
    }

}
