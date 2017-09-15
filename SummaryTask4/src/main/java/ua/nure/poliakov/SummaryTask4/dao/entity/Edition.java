package ua.nure.poliakov.SummaryTask4.dao.entity;

public class Edition {

    private int id;
    private String name;
    private String subject;
    private Double price;
    private int countSubscribe;

    public Edition() {
    }

    public Edition(String name, String subject, Double price) {
        this.name = name;
        this.subject = subject;
        this.price = price;
    }

    public Edition(int id, String name, String subject, Double price) {
        this(name, subject, price);
        this.id = id;
    }

    public Edition(int id, String name, String subject, Double price, int countSubscribe) {
        this(id, name, subject, price);
        this.countSubscribe = countSubscribe;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Double getPrice() {
        return price;
    }

    public int getCountSubscribe() {
        return countSubscribe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCountSubscribe(int countSubscribe) {
        this.countSubscribe = countSubscribe;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", price=" + price +
                ", countSubscribe=" + countSubscribe +
                '}';
    }
}