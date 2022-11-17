package selenide;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Sandbox {

  SelenideElement s = $("");


  @Test
  void utf8() {

    open("");
    $$("a").findBy(text("Broken Images"));


    var element = $$(byText("Name")).findBy(visible);

    $("#command-palette-pjax-container details-dialog");

    {
      SelenideElement button = $("");
      $("button").click();
    }

    {
      var button = $("v2345.b12");
      button.click();
      button.should(disappear);
    }

    {
      var button = $("v2345.b234");
      button.click();
      button.should(disappear);
    }

    $("v2345.b12").click();
    $("v2345.b12").should(disappear);

    $("/html/body/details");

  }


  @Test
  @DisabledIfSystemProperty(named = "selenide.remote", matches = "http.*", disabledReason = "Clipboard not supported on Selenium Grid yet")
    //@Disabled
    //@EnabledIfSystemProperty(named = "environment", matches = "staging")
  void clipboards() {
    open("https://moskva.mts.ru/personal");
    Selenide.clipboard().setText("1234324234");
    $("[name=number]").sendKeys(Keys.COMMAND + "v");
    $("[name=number]").shouldHave(value("(123) 432-42-34"));

    // open page with repository
    open("https://github.com/selenide/selenide.git");
    // find element with copy url - function
    // click copy-button

    // new Assertion in Selenide
    Selenide.clipboard().shouldHave(ClipboardConditions.content("https://github.com/selenide/selenide.git"));
    // old comparison
    // Assertions.assertEquals(Selenide.clipboard().getText(), "https://github.com/selenide/selenide.git");


  }

  @Test
  void ownTextTest() {
    open("https://github.com");
    $("#home-code h3").shouldHave(exactText("Record or rewind any change to your code to keep you and your team in sync."));

  }

  @Test
  void ownText2() {
    open("https://www.tutorialrepublic.com/snippets/preview.php?topic=bootstrap&file=elegant-contact-form");
    $(".alert-info").shouldHave(exactOwnText("on to learn how to customize this layout further. Bootstrap 3 version of this snippet is ."));
  }


  void snapshotsTest() {

    ElementsCollection checkboxes = $$("checkbox").filter(visible);   // Page has 100+  elements
    for (int i = 0; i < 10; i++) {
      checkboxes.get(i).shouldBe(enabled);
    }

    ElementsCollection checkboxesFast = $$("checkbox").filter(visible).snapshot();
    for (int i = 0; i < 10; i++) {
      checkboxesFast.get(i).shouldBe(enabled);
    }

    ElementsCollection collection = $$("").snapshot();
    collection.get(4).shouldHave(text("abc"));
    $("button").click();
    collection.get(5).shouldHave(text("abc"));
  }


}
