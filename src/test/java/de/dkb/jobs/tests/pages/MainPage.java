package de.dkb.jobs.tests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    public MainPage openPage(String url) {
        open(url);
        return this;
    }
    public MainPage checkTitle(String title) {
        String actualTitle = title();
        assertThat(actualTitle).isEqualTo(title);
        return this;
    }

    public void checkTopMenu(String menuItem) {
        $$(".nav-pills").findBy(text(menuItem)).shouldHave(text(menuItem));
    }

    public void checkSearchMainPage(String searchQuery) {
        $(".displayDTM [name='q']").setValue(searchQuery).pressEnter();
    }
}