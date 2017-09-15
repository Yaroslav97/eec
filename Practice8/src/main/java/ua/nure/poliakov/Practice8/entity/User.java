package ua.nure.poliakov.Practice8.entity;

public class User {
    private int id;
    private String login;

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(String login) {
        this.login = login;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return login;
    }
}