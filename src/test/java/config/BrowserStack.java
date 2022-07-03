package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/browserStack.properties")
public interface BrowserStack extends Config {

    String username();

    String key();

    String app();

    @DefaultValue("Google Pixel 4")
    String device();

    @DefaultValue("11.0")
    @Key("os_version")
    String osVersion();

    String baseURL();

    String project();

    String build();

    String testName();
}
