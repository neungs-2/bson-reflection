package model;

public class User {
    public String name;
    public int age;
    public String addr;

    enum Type {
        USER
    }
    public Type getType() {
        return Type.USER;
    }
}
