package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;

public class AgentPage {
    private WebDriver driver;
    
    private By agentName = By.cssSelector("#agent-name, input[name='agentName']");
    private By agentEmail = By.cssSelector("#agent-email, input[name='agentEmail']");
    private By addAgentButton = By.cssSelector("#add-agent-btn, button[type='submit']");
    private By successMessage = By.cssSelector(".alert-success, .toast-success");

    public AgentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAgent(String name, String email) {
        BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(agentName)).sendKeys(name);
        BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(agentEmail)).sendKeys(email);
        BaseClass.wait.until(ExpectedConditions.elementToBeClickable(addAgentButton)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}