package ua.nure.poliakov.SummaryTask3.entity;

public class GrowingTips {
    private Integer temperature;
    private Boolean lightning;
    private Integer watering;

    public Integer getTemperature() {
        return temperature;
    }

    public Boolean getLightning() {
        return lightning;
    }

    public Integer getWatering() {
        return watering;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public void setLightning(Boolean lightning) {
        this.lightning = lightning;
    }

    public void setWatering(Integer watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        return temperature + " " + lightning + " " + watering;
    }
}