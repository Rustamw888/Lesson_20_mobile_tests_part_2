package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.IAndroidEmulator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class EmulatorMobileDriver implements WebDriverProvider {

    static IAndroidEmulator config = ConfigFactory.create(IAndroidEmulator.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(config.platformName());
        options.setDeviceName(config.deviceName());
        options.setPlatformVersion(config.platformVersion());
        options.setApp(app.getAbsolutePath());
        options.setAppPackage("org.wikipedia.alpha");
        options.setAppActivity("org.wikipedia.main.MainActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApp() {
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia" +
                "/releases/download/latest/app-alpha-universal-release.apk";
        String appPath = "src/test/resources/apps/app-alpha-universal-release.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.baseURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
