package com.google.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class SearchResultsPage {
    By RESULTS_CONTAINERS_TITLES=By.xpath("//h3/a");

    public void ensureThatNumberOfSearchResults(Integer expectedNumber) {
        $$(RESULTS_CONTAINERS_TITLES).shouldHaveSize(expectedNumber);
    }

    public void ensureThatResultsContains(String expectedText) {
        $$(RESULTS_CONTAINERS_TITLES).stream().forEach(title-> title.should(text(expectedText)));
    }
}