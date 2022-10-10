package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

  @Test
  void shouldFindSelenideRepositoryAtFirstPlace(){
    open("https://github.com/");
    $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
    $$(".repo-list li").first().$("a").click();

    $("#repository-container-header").shouldHave(text("selenide / selenide"));

  }
}
