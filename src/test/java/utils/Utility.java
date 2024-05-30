package utils;

import com.github.javafaker.Faker;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utility {
    //for reading from config.properties file
    public static String readThePropertyFile(String key) {
        String returningValue = null;
        try {
            PropertiesConfiguration prop = new PropertiesConfiguration("./src/test/resources/config.properties");

            returningValue = (String) prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return returningValue;
    }

    //for writing into config.properties file
    public static void writeIntoPropertyFile(String key, String value) {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
            config.setProperty(key, value);
            config.save();
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }

    //for generating random email and password in config.properties file
    public static void randomInfoGeneration() {
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();
        String password = faker.internet().password(5, 40);
        writeIntoPropertyFile("RandomEmail", randomEmail);
        writeIntoPropertyFile("RandomPassword", password);
    }
}
