package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


class BestContributorToSelenide {

  @Test
  void solntsevShouldBeTheTopContributor() {
    // открыть страницу репозитория селенида
    open("https://github.com/selenide/selenide");
    // подвести мышку к первому аватару из блока contributors
    $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
            .$$("ul li").first().hover();
    // проверка: во всплывающем окне есть текст Andrei Solntsev
    $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    $x("//div").shouldBe(visible);
  }


}


