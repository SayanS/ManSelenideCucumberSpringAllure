package com.google.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            makeScreenshot(scenario.getName());
            getWebDriver().quit();
        }
    }

    @Attachment(value = "Page screenshot - {0}", type = "image/png")
    private byte[] makeScreenshot(String fileName) {
        return (((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES));
    }
}
