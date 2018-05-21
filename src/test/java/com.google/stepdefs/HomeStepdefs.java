package com.google.stepdefs;

import com.google.pages.HomePage;
import cucumber.api.java8.En;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

@ContextConfiguration("file:src/test/java/spring.xml")
public class HomeStepdefs implements En {

    @Autowired
    private HomePage homePage;

    public HomeStepdefs() {

        Given("^Home page is opened$", () -> {
            open(baseUrl, HomePage.class);
        });

        When("^Global search for \"([^\"]*)\"$", (String text) -> {
            homePage.globalSearchFor(text);
        });

        Then("^The values of Global search drop-down list should contain \"([^\"]*)\"$", (String text) -> {
            homePage.ensureThatGlobalSearchDropDownValuesContains(text);
        });

        When("^Enter \"([^\"]*)\" into Global search field$", (String text) -> {
            homePage.enterIntoGlobalSearchField(text);
        });
    }
}



