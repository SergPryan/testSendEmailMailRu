package testCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends Page {

    private final By domainId =By.id("mailbox:domain");

    private final By loginId = By.id("mailbox:login");

    private final By passwordId= By.id("mailbox:password");

    private final By loginBtn = By.id("mailbox:submit");

    private final String login;
    private final String password;
    private final String domain;

    public LoginPage(WebDriver driver, String login, String password) {
        super(driver);
        this.login = login.split("@")[0];
        this.domain = login.split("@")[1];
        this.password = password;
    }

    public void selectDomain(){
        driver.findElement(domainId).click();
        Select selectDomain = new Select( driver.findElement(domainId));
        selectDomain.selectByVisibleText("@"+domain);
        driver.findElement(loginId).sendKeys(login);
        driver.findElement(passwordId).sendKeys(password);
        driver.findElement(loginBtn).findElement(By.className("o-control")).submit();
    }

}
