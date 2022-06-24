package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("screen")
public class GettingStartedOnboardingScreenTests extends TestBase {

    @Test
    void firstSearchPositiveTest() {

        step("First page checking", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("We’ve found the following on your device:"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Second page checking", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Third page checking", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Fourth page checking", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/switchView")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).shouldHave(text("GET STARTED")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(visible);
        });
    }
}
