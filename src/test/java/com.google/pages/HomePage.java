package com.google.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class HomePage {

    private SelenideElement globalSearchField = $("input#lst-ib");
    private String GLOBAL_SEARCH_DROP_DOWN_VALUES = "div.sbqs_c";

    public void globalSearchFor(String text) {
        globalSearchField.val(text).pressEnter();
    }

    public void ensureThatGlobalSearchDropDownValuesContains(String expectedText) {
        $$(GLOBAL_SEARCH_DROP_DOWN_VALUES).get(0).waitUntil(visible, 5000);
        $$(GLOBAL_SEARCH_DROP_DOWN_VALUES).stream().forEach(element -> {
            element.should(text(expectedText));
        });
    }
    public void enterIntoGlobalSearchField(String text) {
        globalSearchField.val(text);
    }
}



