package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConfigurationParameters {


  @Test
  void doSomethingForUser(){
    var url=System.getProperty("userUrl");
    open(url+"/login");
  }

  @Test
  void doSomethingForAdmin(){
    var url=System.getProperty("adminUrl");
    open(url+"/login");
  }
}
