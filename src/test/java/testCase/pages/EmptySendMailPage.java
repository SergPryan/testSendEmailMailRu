package testCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EmptySendMailPage extends Page {

    private final By address = By.cssSelector("textarea[data-original-name]");

    private final By bodyMailFrame = By.xpath("//iframe[starts-with(@id,'toolkit-')]");

    private final By bodyFrame = By.id("tinymce");

    private final String recipient;
    private final String bodyMail;

    public EmptySendMailPage(WebDriver driver, String recipient, String bodyMail) {
        super(driver);
        this.recipient= recipient;
        this.bodyMail=bodyMail;
    }

    public void sendEmail(){
        driver.findElement(address).sendKeys(recipient);
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(recipient);
        driver.switchTo().frame(driver.findElement(bodyMailFrame));
        driver.findElement(bodyFrame).click();
        driver.findElement(bodyFrame).sendKeys(bodyMail);
        driver.findElement(bodyFrame).sendKeys(Keys.CONTROL,Keys.ENTER);
    }
}
