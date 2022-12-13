package github;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

  @Test
  void shouldFindSelenideRepositoryAtTheTop() {
    // открыть браузер на странице гитхаб
    open("https://github.com/");
    // ввести в поле поиска "selenide" и нажать на enter
    $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
    // в списке найденных репозиториев кликнуть на первый
    $$("ul.repo-list li").first().$("a").click();
    // проверка: в шапке репозитория текст "selenide/selenide"
    $("#repository-container-header").shouldHave(text("selenide / selenide"));

  }
}
