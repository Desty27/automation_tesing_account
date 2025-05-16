package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private WebDriver driver;
    
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By passwordField = By.id("password");
    private By planDropdown = By.id("plan");
    private By registerButton = By.id("register-btn");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String name, String email, String phone, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectCalleyPlan() {
        new Select(driver.findElement(planDropdown)).selectByVisibleText("Calley Teams");
    }

    public void submitRegistration() {
        driver.findElement(registerButton).click();
    }
}