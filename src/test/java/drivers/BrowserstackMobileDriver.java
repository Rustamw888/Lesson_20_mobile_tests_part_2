package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStack;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static BrowserStack configBS = ConfigFactory.create(BrowserStack.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", configBS.username());
        mutableCapabilities.setCapability("browserstack.key", configBS.key());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", configBS.app());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", configBS.device());
        mutableCapabilities.setCapability("os_version", configBS.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", configBS.project());
        mutableCapabilities.setCapability("build", configBS.build());
        mutableCapabilities.setCapability("name", configBS.testName());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(configBS.baseURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
