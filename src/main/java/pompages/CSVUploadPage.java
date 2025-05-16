package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CSVUploadPage {
    private WebDriver driver;
    
    private By listNameField = By.id("list-name");
    private By csvUploadField = By.id("csv-upload");
    private By mapNameField = By.id("map-name");
    private By mapContactField = By.id("map-contact");
    private By importButton = By.id("import-btn");
    private By successMessage = By.id("import-success");

    public CSVUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadCSV(String listName, String csvPath) {
        driver.findElement(listNameField).sendKeys(listName);
        driver.findElement(csvUploadField).sendKeys(csvPath);
        
        new Select(driver.findElement(mapNameField)).selectByVisibleText("Name");
        new Select(driver.findElement(mapContactField)).selectByVisibleText("Contact");
        
        driver.findElement(importButton).click();
    }

    public boolean isUploadSuccessful() {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(successMessage))
            .isDisplayed();
    }
}