package util;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class StringGenerationUtil {

    public static String getGeneratedString() {
        int lenght= DataManager.getTestData().getStringLenght();
        String generatedText = RandomStringUtils.randomAlphanumeric(lenght);
        System.out.println(generatedText);

        return generatedText;
    }
}
