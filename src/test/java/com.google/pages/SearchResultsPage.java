package com.google.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class SearchResultsPage {
    By resultsContainersTitles=By.xpath("//h3/a");

    public void ensureThatNumberOfSearchResults(Integer expectedNumber) {
        $$(resultsContainersTitles).shouldHaveSize(expectedNumber);
    }

    public void ensureThatResultsContains(String expectedText) {
        $$(resultsContainersTitles).forEach(title-> title.should(text(expectedText)));
    }
}