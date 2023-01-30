package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static TestData testData = null;
    private static String JSON_CONFIG_SOURCE = "src/main/resources/config.json";
    private static String JSON_TEST_SOURCE = "src/main/resources/testData.json";
    static final Logger logger = Logger.getLogger(DataManager.class);
    private static JSONParser parser = new JSONParser();

    public static List<String> getListOfConfigDataByName(String name) {
        List<String> list = new ArrayList<>();
        try(FileReader reader=new FileReader(JSON_CONFIG_SOURCE)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray elements = (JSONArray) jsonObject.get(name);
            for (Object object : elements) {
                list.add(object.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getConfigDataByName(String name) {
        String value = null;
        try(FileReader reader=new FileReader(JSON_CONFIG_SOURCE)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            value = (String) jsonObject.get(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static TestData getTestData() {
        if (testData == null) {
            logger.debug(" get data from TestData");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                testData = objectMapper.readValue(new File(JSON_TEST_SOURCE), TestData.class);
            } catch (IOException e) {
                logger.error("testData is not available " + e);
                e.printStackTrace();
            }
            return testData;
        }
        return testData;
    }
}






