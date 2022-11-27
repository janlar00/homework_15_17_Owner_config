package de.dkb.jobs.tests.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;

import org.openqa.selenium.WebElement;

public class QaPositionPage {
    public void checkPositionDescription() {
        $(".jobTitle").scrollIntoView(true).click();
        $$(".labels .labels__item").filterBy(text("Vollzeit")).shouldHave(size(1));
    }
}
