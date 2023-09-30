package org.sonatype.mavenbook.ch04;

/**
 *  Weather 模型对象只保存温度，湿度和当前天气情况的文字描述
 * 等信息
 */

public class Weather {
    private String province;
    private String city;
    private String humidity;
    private String temperature;
    private String reporttime;
    private String winddirection;
    private String weather;

    public Weather() {}

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getReporttime() {
        return reporttime;
    }

    public void setReporttime(String reporttime) {
        this.reporttime = reporttime;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", humidity='" + humidity + '\'' +
                ", temperature='" + temperature + '\'' +
                ", reporttime='" + reporttime + '\'' +
                ", winddirection='" + winddirection + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}