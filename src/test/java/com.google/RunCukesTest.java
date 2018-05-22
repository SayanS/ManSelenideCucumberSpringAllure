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

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/resources/features"},
                 glue = "com/google/stepdefs")
public class RunCukesTest {
    @BeforeClass
    static public void setUp() {
        Properties properties = new Properties();
        String resourcesPath = "./src/test/java/resources/config.properties";
        try (InputStream input = new FileInputStream(resourcesPath)) {
            properties.load(input);
            Configuration.browser = properties.getProperty("myBrowser");
            Configuration.baseUrl = properties.getProperty("myBaseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration.screenshots = false;
    }
}
