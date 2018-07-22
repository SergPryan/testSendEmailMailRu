package testCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMailPage extends Page {

    private final By createMailBtn = By.linkText("Написать письмо");

    public MainMailPage(WebDriver driver) {
        super(driver);
    }

    public void createEmptyMail(){
        driver.findElement(createMailBtn).click();
    }


}
