package org.sonatype.mavenbook.ch04;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws Exception {
        String zipCode = "110000";
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key=9dbe7b1e241bab7fceb95e25864364db&city="+zipCode;
        URLConnection conn = new URL(url).openConnection();

        conn.connect();

        BufferedReader reader;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine;

        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((tempLine = reader.readLine()) != null) {
            resultBuffer.append(tempLine);
        }
        System.out.println(resultBuffer);
        reader.close();

        JSONObject jsonObject = JSON.parseObject(resultBuffer.toString());

        System.out.println(jsonObject.get("lives"));

        JSONArray jsonArray = (JSONArray) jsonObject.get("lives");
        System.out.println(jsonArray);

        System.out.println(jsonArray.get(0));

        JSONObject parse = JSON.parseObject(jsonArray.get(0).toString());
        System.out.println(parse.get("province"));
        System.out.println(parse.get("city"));
        System.out.println(parse.get("adcode"));
        System.out.println(parse.get("temperature_float"));
        System.out.println(parse.get("humidity_float"));
        System.out.println(parse.get("windpower"));
        System.out.println(parse.get("weather"));
        System.out.println(parse.get("temperature"));
        System.out.println(parse.get("humidity"));
        System.out.println(parse.get("reporttime"));
        System.out.println(parse.get("winddirection"));

    }
}
