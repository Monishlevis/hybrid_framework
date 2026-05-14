package utils;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

    public static String getData(String key) {
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("src/test/resources/data/loginData.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            return (String) jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}