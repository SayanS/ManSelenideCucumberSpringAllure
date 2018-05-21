package com.google.stepdefs;

import com.google.pages.SearchResultsPage;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("file:src/test/java/spring.xml")
public class SearchStepdefs implements En {

    @Autowired
    SearchResultsPage searchResultsPage;

    public SearchStepdefs() {

        Then("^Search results page should be displayed with (\\d+) results$", (Integer expectedNumber) -> {
            searchResultsPage.ensureThatNumberOfSearchResults(expectedNumber);
        });

        Then("^Search results should contain \"([^\"]*)\"$", (String text) -> {
            searchResultsPage.ensureThatResultsContains(text);
        });
    }
}
