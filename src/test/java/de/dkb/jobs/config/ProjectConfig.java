package de.dkb.jobs.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties"
})
public interface ProjectConfig extends Config {

    @Key("baseURL")
    @DefaultValue("https://jobs.dkb.de")
    String baseURL();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserMobileView")
    @DefaultValue("")
    String browserMobileView();

    @Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    @Key("videoStorage")
    @DefaultValue("")
    String videoStorage();
}
