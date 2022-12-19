package github;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

  @Test
  void shouldFindSelenideRepositoryAtTheTop() {
    // открыть главную страницу
    open("https://github.com/");
    // ввести в поле поиска selenide и нажать enter
    $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
    // кликнуть на первый репозиторий из списка найденых
    $$("ul.repo-list li").first().$("a").click();
    // проверка: заголовок selenide/selenide
    $("#repository-container-header").shouldHave(text("selenide / selenide"));
  }
}
