package model;

public abstract class Coin {
    public enum Type {
        NONE, BITCOIN, ETHEREUM
    }

    public abstract Type getType();

    public String addr;
    public String from;
    public String to;
}
