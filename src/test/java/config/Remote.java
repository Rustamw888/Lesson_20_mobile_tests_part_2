package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/remote.properties")
public interface Remote extends Config {

    String username();

    String key();

    String app();

    @DefaultValue("Samsung Galaxy S22 Ultra")
    String device();

    @DefaultValue("12.0")
    @Key("os_version")
    String osVersion();

    String baseURL();

    String project();

    String build();

    String testName();
}
