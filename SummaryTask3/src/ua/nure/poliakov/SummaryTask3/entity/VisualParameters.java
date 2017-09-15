package ua.nure.poliakov.SummaryTask3.entity;

public class VisualParameters {

    private String stemColor;
    private String leafColor;
    private String averageSize;

    public String getStemColor() {
        return stemColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public String getAverageSize() {
        return averageSize;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public void setAverageSize(String averageSize) {
        this.averageSize = averageSize;
    }

    @Override
    public String toString() {
        return stemColor + " " + leafColor + " " + averageSize;
    }
}