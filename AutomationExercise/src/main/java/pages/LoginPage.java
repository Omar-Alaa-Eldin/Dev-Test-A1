package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private final By userNameBox = By.id("username");
    private final By passwordBox = By.id("password");
    private final By loginButton = By.className("radius");
    private final By errorMessage = By.id("flash");

    //Actions
    public void enterUsername(String username){
        driver.findElement(userNameBox).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }

    public SecureAreaPage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
