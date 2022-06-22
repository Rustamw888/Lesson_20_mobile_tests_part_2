package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("android")
public class HomeWorkTest extends TestBase {

    @Test
    void firstSearchPositiveTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Star wars");
        });

        step("Verify content found", () ->
                $$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));

        step("Verify content found", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_image")).shouldBe(visible));

        step("Verify image is visible", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .find(matchText("Star Wars")).click();

            $(AppiumBy.id("org.wikipedia.alpha:id/view_page_header_image")).shouldBe(visible);
        });
    }

    @Test
    void secondSearchPositiveTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Star Wars");
        });

        step("Assert textView", () -> {
            String actualText = $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().text();
            assertEquals(actualText, "Star Wars");
        });
    }

    @Test
    void searchNegativeTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("__________________");
        });

        step("Verify no results displayed", () ->
        $(AppiumBy.id("org.wikipedia.alpha:id/results_text"))
                .shouldHave(text("No results"))
        );
    }
}
