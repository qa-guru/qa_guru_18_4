package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideContributors {

  @Test
  void solntsevShouldBeTheTopContributor() {
    // open selenide repository
    open("https://github.com/selenide/selenide");
    // hover mouse over the first avatar in contributors block
    $("div.Layout-sidebar").find(byText("Contributors"))
            .ancestor("div").$$("ul li").first().hover();

    // check: the popup window has text Andrei Solntsev
    $$(".Popover").findBy(visible).shouldHave(text(("Andrei Solntsev")));

  }
}
