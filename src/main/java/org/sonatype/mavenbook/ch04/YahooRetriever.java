package org.sonatype.mavenbook.ch04;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
public class YahooRetriever {
    private static final Logger log = Logger.getLogger(YahooRetriever.class);

    public InputStream retrieve(int zipcode) throws Exception {
        log.info("Query weather...");
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key=9dbe7b1e241bab7fceb95e25864364db&city=" + zipcode;
        URLConnection conn = new URL(url).openConnection();
        conn.connect();
        return conn.getInputStream();
    }
}
