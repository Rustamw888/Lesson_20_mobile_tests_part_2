package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/realDevice.properties")
public interface RealDevice extends Config {

    String baseURL();

    @Key("platform_name")
    String platformName();

    @DefaultValue("LLD-L31")
    @Key("device_name")
    String deviceName();

    @DefaultValue("9.1.0")
    @Key("platform_version")
    String platformVersion();
}
