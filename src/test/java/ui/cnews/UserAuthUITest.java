package ui.cnews;

import cnews.CNewsApp;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("/test-servlet-context.xml")
public class UserAuthUITest {

  @Value("${server.address}")
  String serverAddress;

  @Value("${server.port}")
  String serverPort;

  @BeforeClass
  public static void init() throws Exception {
    SpringApplication.run(CNewsApp.class);
  }

  @Before
  public void openApplicationInBrowser() throws Exception {
    open("http:" + serverAddress + ":" + serverPort + "/");
  }

  @Test
  public void showUserLoginAfterSuccessfulLogin() throws Exception {
    $(By.id("login-form-link")).click();
    $(By.name("login")).setValue("testuser");
    $(By.name("password")).setValue("12345");
    $(By.id("login-btn")).click();
    $(By.id("sign-up-link")).should(disappear);
    $(By.id("login-form-link")).should(disappear);
    $(By.id("logged-user")).shouldHave(text("logged as testuser"));
  }

  @Test
  public void showAlertAfterUnsuccessfulLogin() throws Exception {
    $(By.id("login-form-link")).click();
    $(By.name("login")).setValue("unknownuser");
    $(By.name("password")).setValue("unknownpasswd");
    $(By.id("login-btn")).click();
    $(By.className("alert-danger")).shouldHave(text("Error. Incorrect login or password"));
  }
}
