package org.sonatype.mavenbook.ch04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

public class YahooParser {
    private static final Logger log = Logger.getLogger(YahooParser.class);

    public Weather parse(InputStream inputStream) throws Exception {
        Weather weather = new Weather();

        log.info("Parse json string");
        BufferedReader reader;
        StringBuilder resultBuffer = new StringBuilder();
        String tempLine;

        reader = new BufferedReader(new InputStreamReader(inputStream));
        while ((tempLine = reader.readLine()) != null) {
            resultBuffer.append(tempLine);
        }
        reader.close();

        log.info(resultBuffer.toString());
        JSONObject jsonObject = JSON.parseObject(resultBuffer.toString());
        JSONArray jsonArray = (JSONArray) jsonObject.get("lives");
        JSONObject parse = JSON.parseObject(jsonArray.get(0).toString());

        weather.setProvince(parse.get("province").toString());
        weather.setCity(parse.get("city").toString());
        weather.setTemperature(parse.get("temperature").toString());
        weather.setHumidity(parse.get("humidity").toString());
        weather.setWeather(parse.get("weather").toString());
        weather.setReporttime(parse.get("reporttime").toString());
        weather.setWinddirection(parse.get("winddirection").toString());

        return weather;
    }
}