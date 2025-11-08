package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

   public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final By forgotPasswordLink = By.linkText("Forgot Password");

   //Actions
    public LoginPage clickOnFormAuthenticationLink(){
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }

    public ForgotPassword clickOnForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPassword(driver);
    }
}
