package ua.nure.poliakov.SummaryTask3.entity;

public class Flower {

    private String name;
    private String soil;
    private String origin;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;
    private String multiplying;

    public Flower() {
    }

    public Flower(String name, String soil, String origin, VisualParameters visualParameters, GrowingTips growingTips, String multiplying) {
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
    }

    public String getName() {
        return name;
    }

    public String getSoil() {
        return soil;
    }

    public String getOrigin() {
        return origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        return "Flower" + System.lineSeparator() +
                name + System.lineSeparator() +
                soil + System.lineSeparator() +
                origin + System.lineSeparator() +
                visualParameters + System.lineSeparator() +
                growingTips + System.lineSeparator() +
                multiplying + System.lineSeparator();
    }
}