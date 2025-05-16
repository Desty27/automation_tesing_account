import base.BaseClass;
import pompages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FullSetupTest extends BaseClass {
    
    @Test(priority=1)
    public void testLogin() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/data.properties"));
        
        driver.get(prop.getProperty("login.url"));
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("valid.email"), prop.getProperty("valid.password"));

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not displayed after login");
    }

    @Test(priority=2, dependsOnMethods = "testLogin")
    public void testAddAgent() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/data.properties"));
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToAgents();
        
        AgentPage agentPage = new AgentPage(driver);
        agentPage.addAgent("Test Agent", "agent@test.com");
        
        Assert.assertTrue(agentPage.isSuccessMessageDisplayed(), "Agent creation failed");
    }

    @Test(priority=3, dependsOnMethods = "testLogin")
    public void testCSVUpload() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/data.properties"));
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToCallLists();
        
        CSVUploadPage csvPage = new CSVUploadPage(driver);
        csvPage.uploadCSV("Test List", prop.getProperty("csv.path"));
        
        Assert.assertTrue(csvPage.isUploadSuccessful(), "CSV upload failed");
    }
}