package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    WebDriver driver;
    public SecureAreaPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private final By successMessage = By.id("flash");

    //Actions
    public String getSuccessMessage(){
        return driver.findElement(successMessage).getText();
    }
}
