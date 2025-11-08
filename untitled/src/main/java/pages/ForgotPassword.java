package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    public WebDriver driver;

    public ForgotPassword(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private final By userEmailBox = By.id("email");
    private final By formSubmitButton = By.id("form_submit");
    private final By errorMessage = By.xpath("//*[contains(text(),'Server')]");


    //Actions
    public void insertUserEmail(String userMail){
        driver.findElement(userEmailBox).sendKeys(userMail);
    }

    public void clickOnFormSubmitButton(){
        driver.findElement(formSubmitButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
