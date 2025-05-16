package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;

public class LoginPage {
    private WebDriver driver;
    
    private By emailField = By.cssSelector("input[type='email'], #email");
    private By passwordField = By.cssSelector("input[type='password'], #password");
    private By loginButton = By.cssSelector("button[type='submit'], #login-btn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        BaseClass.wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}