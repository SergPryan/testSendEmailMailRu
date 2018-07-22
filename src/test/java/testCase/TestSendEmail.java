package testCase;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import testCase.pages.EmptySendMailPage;
import testCase.pages.LoginPage;
import testCase.pages.MainMailPage;

import java.util.concurrent.TimeUnit;

public class TestSendEmail extends JUnitTestBase {

  @Before
  public void setup(){
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testSendEmail(){
    driver.get("https://mail.ru/");
    LoginPage loginPage = new LoginPage(driver,"login@mail.ru","Tganbc_84");
    Assert.assertEquals("Mail.Ru: почта, поиск в интернете, новости, игры", driver.getTitle());
    loginPage.selectDomain();
    MainMailPage mainMailPage = new MainMailPage(driver);
    mainMailPage.createEmptyMail();
    EmptySendMailPage emptySendMailPage = new EmptySendMailPage(driver,"login@mail.ru","body123");
    emptySendMailPage.sendEmail();
  }

  @After
  public void close(){
    driver.close();
  }

}
