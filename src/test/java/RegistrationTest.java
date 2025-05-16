import base.BaseClass;
import pompages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RegistrationTest extends BaseClass {
    
    @Test
    public void testUserRegistration() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/data.properties"));
        
        driver.get(prop.getProperty("registration.url"));
        
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.enterDetails("John Doe", "john.doe@example.com", "8698111111", "SecurePass123");
        regPage.selectCalleyPlan();
        regPage.submitRegistration();

        Assert.assertNotEquals(driver.getCurrentUrl(), prop.getProperty("registration.url"), 
            "Registration failed - still on registration page");
    }
}