package de.dkb.jobs.tests;

import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.dkb.jobs.tests.pages.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SomeJobPortalTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    QaPositionPage qaPositionPage = new QaPositionPage();
    @Disabled
    @Test
    @DisplayName("Checking title on the main page")
    void checkTitle() {
        step("Open homepage", () -> {
            mainPage.openPage("/");
        });

        step("Check title", () -> {
            mainPage.checkTitle("Deine Karriere gestaltest Du mit der DKB");
        });
    }
    @Disabled
    @Test
    @DisplayName("Checking the top menu for correct data")
    void checkTopMenu() {
        String[] menuItems = {"Karriereseite", "DKB Backstage", "FAQ", "Job finden"};

        step("Open homepage", () -> {
            mainPage.openPage("/");
        });

        step("Check top menu", () -> {
            for (String menuItem : menuItems) {
                mainPage.checkTopMenu(menuItem);
            }
        });
    }

    @Test
    @Feature("Issue XYZ")
    @Story("Implement issue XYZ")
    @Owner("JL")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://jobs.dkb.de")
    @DisplayName("Checking whether the QA position is a full-time job")
    void checkSearchMainPage() {
        final String JOBTITLE = "Quality Assurance Engineer";

        step("Open homepage", () -> {
            mainPage.openPage("/");
        });

        step("Enter the query and press enter", () -> {
            mainPage.checkSearchMainPage(JOBTITLE);
        });

        step("The result should return one QA position", () -> {
            searchResultsPage.checkResults(1, JOBTITLE);
        });

        step("Open QA position description", () -> {
            searchResultsPage.openQAPosDescription(JOBTITLE);
        });

        step("Check whether is a full-time position", () -> {
            qaPositionPage.checkPositionDescription();
        });
    }
}
