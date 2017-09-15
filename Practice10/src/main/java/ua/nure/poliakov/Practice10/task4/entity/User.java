package ua.nure.poliakov.Practice10.task4.entity;

public class User {
    String login;
    String pass;
    String role_id;
    String name;

    public User() {
    }

    public User(String login, String pass, String role_id, String name) {
        this.login = login;
        this.pass = pass;
        this.role_id = role_id;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getRole_id() {
        return role_id;
    }

    public String getName() {
        return name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role_id='" + role_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
