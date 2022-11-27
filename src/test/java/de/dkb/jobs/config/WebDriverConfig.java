package de.dkb.jobs.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        //"system:properties",
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseURL")
    @DefaultValue("https://jobs.dkb.de")
    String baseURL();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("107.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    /*@Key("browserMobileView")
    @DefaultValue("")
    String browserMobileView();
    */

    @Key("videoStorage")
    @DefaultValue("")
    String videoStorage();
}
