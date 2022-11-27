package de.dkb.jobs.tests.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public void checkResults(int numberPositions, String jobTitle) {
        $$("table#searchresults > tbody").filterBy(text(jobTitle)).shouldHave(size(numberPositions));
    }
    public void openQAPosDescription(String jobTitle) {
        $(byText(jobTitle)).click();
    }
}
