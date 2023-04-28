package PaooGame.Items;

public enum Battery {
    good(0),
    bad(1);

    private final int info;
    Battery(int info) {
        this.info=info;
    }

    public int getInfo() {
        return info;
    }
}
