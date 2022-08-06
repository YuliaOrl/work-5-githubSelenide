package githab;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepository {

    @Test
    void shouldFindePageSoftAssertionsTest() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("div.js-wiki-sidebar-toggle-display").shouldHave(text("SoftAssertions"));
        $("a[href$='SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
