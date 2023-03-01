package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class DragAndDrop {

  @Test
  void dragAndDrop(){
    Configuration.fastSetValue=true;
    open("https://the-internet.herokuapp.com/drag_and_drop");
    $("#column-a").shouldHave(exactText("A"));
    //$("#column-b").dragAndDropTo("#column-a");

    $("#column-b").hover();
    actions().clickAndHold().moveByOffset(-200, 0).release().perform();
    $("#column-a").shouldHave(exactText("B"));

  }


  @Test
  void testA(){
    // arrange
    var a=0;
    // act
    // switchAon()
    // assert
    // assert a.width=50
    // assert a.height=100
    // assert a.weight=200
  }

  @Test
  void testB(){
    // arrange
    var b=0;
    // act
    // switchBon()
    // assert
    // assert b.width=50
    // assert b.height=100
    // assert b.weight=200
  }

  void asset_that_everything_is_okay(String param){
    // assert param.width=50
    // assert param.height=200
    // assert param.weight=200
  }

  @Test
  void openSites(String URL){
    open(URL);
    $("h1").shouldHave(text("BMW"));
  }

  @Test
  void checkUrl(){
    webdriver().shouldHave(url("http://google.com"));

  }

  @Test
  void infiniteScroll(){
    open("https://infinite-scroll.com/demo/full-page/");
    $(Selectors.withTagAndText("h2","2a")).shouldNotBe(visible);
   //$(Selectors.withTagAndText("h2","1b")).hover();
    $$("article").shouldHave(size(2));
    $("article",1).hover();
    $$("article").shouldHave(size(5));


    $(Selectors.withTagAndText("h2","2a")).shouldBe(visible);

  }
}
