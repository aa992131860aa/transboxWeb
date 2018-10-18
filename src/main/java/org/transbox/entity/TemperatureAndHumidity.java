package org.transbox.entity;

public class TemperatureAndHumidity {
    private double temperature;
    private double humidity;
    private String recordAt;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(String recordAt) {
        this.recordAt = recordAt;
    }

    @Override
    public String toString() {
        return "TemperatureAndHumidity{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", recordAt='" + recordAt + '\'' +
                '}';
    }
}
