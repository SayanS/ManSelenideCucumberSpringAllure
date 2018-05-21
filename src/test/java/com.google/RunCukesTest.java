package com.google;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.baseUrl;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/resources/features"},
                 glue = "com/google/stepdefs")
public class RunCukesTest {
    @BeforeClass
    static public void setUp() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("./src/test/java/resources/config.properties");
            prop.load(input);
            baseUrl = prop.getProperty("myBaseUrl");
            Configuration.browser = prop.getProperty("myBrowser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration.screenshots = false;
    }
}
