package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;

public class DashboardPage {
    private WebDriver driver;
    
    private By dashboardHeader = By.cssSelector(".dashboard-header, h1");
    private By agentsLink = By.xpath("//a[contains(text(),'Agents') or contains(@href,'agents')]");
    private By callListsLink = By.xpath("//a[contains(text(),'Call Lists') or contains(@href,'calllists')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        return BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }

    public void navigateToAgents() {
        BaseClass.wait.until(ExpectedConditions.elementToBeClickable(agentsLink)).click();
        BaseClass.wait.until(ExpectedConditions.urlContains("agents"));
    }

    public void navigateToCallLists() {
        BaseClass.wait.until(ExpectedConditions.elementToBeClickable(callListsLink)).click();
        BaseClass.wait.until(ExpectedConditions.urlContains("calllists"));
    }
}