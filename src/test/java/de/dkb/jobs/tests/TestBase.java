package de.dkb.jobs.tests;

import static com.codeborne.selenide.Selenide.open;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import de.dkb.jobs.config.WebDriverProvider;
import de.dkb.jobs.helpers.AddAttachments;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;

@ExtendWith({ AllureJunit5.class})
public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        WebDriverProvider.config();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        AddAttachments.screenshotAs("Last screenshot");
        AddAttachments.addVideo();
        AddAttachments.browserConsoleLogs();
        AddAttachments.pageSource();
    }
}
