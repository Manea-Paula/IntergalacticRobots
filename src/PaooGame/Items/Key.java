package PaooGame.Items;

public enum Key {
    found(1),
    notFound(0);

    private final int info;

    Key(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }
}
