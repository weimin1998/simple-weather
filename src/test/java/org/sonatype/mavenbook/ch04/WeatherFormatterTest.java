package org.sonatype.mavenbook.ch04;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WeatherFormatterTest extends TestCase {

    public void testFormatter() throws Exception {
        Weather weather = new Weather();
        weather.setProvince("shanxi");
        weather.setCity("yuncheng");
        weather.setTemperature("20");
        weather.setHumidity("32");
        weather.setWeather("sun");
        weather.setReporttime("2023-09-30 09:12:05");
        weather.setWinddirection("east");

        WeatherFormatter weatherFormatter = new WeatherFormatter();

        String expected = weatherFormatter.format(weather);

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("mockWeather.txt");
        BufferedReader reader;
        StringBuilder resultBuffer = new StringBuilder();
        String tempLine;

        assert inputStream != null;
        reader = new BufferedReader(new InputStreamReader(inputStream));
        while ((tempLine = reader.readLine()) != null) {
            resultBuffer.append(tempLine);
            resultBuffer.append("\r\n");
        }
        String actual = resultBuffer.substring(0, resultBuffer.length() - 1).trim();
        reader.close();

        assertEquals(expected, actual);
    }
}
