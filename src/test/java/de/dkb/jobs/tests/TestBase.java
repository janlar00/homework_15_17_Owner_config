package de.dkb.jobs.tests;

import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import de.dkb.jobs.config.Project;
import de.dkb.jobs.helpers.Attach;
import de.dkb.jobs.helpers.DriverSettings;
import de.dkb.jobs.helpers.DriverUtils;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;

@ExtendWith({ AllureJunit5.class})
public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        DriverSettings.configure();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        Attach.addScreenshotAs("Last screenshot");
        Attach.addPageSource();
        Attach.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            Attach.addVideo(sessionId);
        }
    }
}
