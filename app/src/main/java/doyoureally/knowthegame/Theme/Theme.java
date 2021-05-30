package doyoureally.knowthegame.theme;

public class Theme {
    private final String name;
    private final int picture;

    public Theme(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "Nom = " + name;
    }
}
