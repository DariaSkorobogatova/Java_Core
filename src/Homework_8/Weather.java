package Homework_8;

public class Weather {
    private String city;
    private String localDate;
    private String iconPhrase;
    private String temperatureMax;
    private String temperatureMin;

    public Weather() {

    }

    public Weather(String city, String localDate, String iconPhrase, String temperatureMax, String temperatureMin) {
        this.city = city;
        this.localDate = localDate;
        this.iconPhrase = iconPhrase;
        this.temperatureMax = temperatureMax;
        this.temperatureMin = temperatureMin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }
}
