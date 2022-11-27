package de.dkb.jobs.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;

public class WebDriverProvider {
    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    /*public static boolean isWebMobile() {
        return !config.browserMobileView().equals("");
    }*/

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }
    public static void config() {
    Configuration.baseUrl = WebDriverProvider.config.baseURL();
    Configuration.browser = WebDriverProvider.config.browser();
    Configuration.browserVersion = WebDriverProvider.config.browserVersion();
    Configuration.browserSize = WebDriverProvider.config.browserSize();


    DesiredCapabilities capabilities = new DesiredCapabilities();
    ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (WebDriverProvider.isRemoteWebDriver()) {
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.remote = WebDriverProvider.config.remoteDriverUrl();
    }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
