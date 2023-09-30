package org.sonatype.mavenbook.ch04;

import junit.framework.TestCase;

import java.io.InputStream;

public class YahooParserTest extends TestCase {

    public void testParser() throws Exception {
        InputStream mockData = getClass().getClassLoader().getResourceAsStream("mockResponse.json");

        YahooParser yahooParser = new YahooParser();

        Weather weather = yahooParser.parse(mockData);

        assertEquals(weather.getProvince(),"shanxi");
        assertEquals(weather.getCity(),"yuncheng");
        assertEquals(weather.getWeather(),"sun");
        assertEquals(weather.getHumidity(),"32");
        assertEquals(weather.getTemperature(),"20");
        assertEquals(weather.getReporttime(),"2023-09-30 09:12:05");
        assertEquals(weather.getWinddirection(),"east");
    }
}
