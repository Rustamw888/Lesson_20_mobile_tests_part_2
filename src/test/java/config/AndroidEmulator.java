package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/androidEmulator.properties")
public interface AndroidEmulator extends Config {

    String baseURL();

    @Key("platform_name")
    String platformName();

    @DefaultValue("Pixel 4 API 30")
    @Key("device_name")
    String deviceName();

    @DefaultValue("11.0")
    @Key("platform_version")
    String platformVersion();
}
