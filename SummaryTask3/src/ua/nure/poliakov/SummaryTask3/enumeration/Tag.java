package ua.nure.poliakov.SummaryTask3.enumeration;

public enum Tag {
    GREENHOUSE("Greenhouse"), FLOWER("Flower"), NAME("name"), SOIL("soil"), ORIGIN("origin"),
    VISUALPARAMETERS("visualParameters"), GROWINGTIPS("growingTips"), MULTIPLYING("multiplying"),
    STEMCOLOR("stemColor"), LEAFCOLOR("leafColor"), AVERAGESIZE("averageSize"),
    TEMPERATURE("temperature"), LIGHTNING("lightning"), WATERING("watering");

    private String value;

    Tag(String value) {
        this.value = value;
    }

    public boolean equalsTo(String name) {
        return value.equals(name);
    }

    public String value() {
        return value;
    }
}