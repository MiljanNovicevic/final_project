import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BaseTest {

    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    protected ProfilePage profilePage;
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navPage = new NavPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss").format(new Date());
            Files.copy(file.toPath(), new File("screenshots/" + result.getName() + " - " + timestamp + ".png")
                    .toPath());
        }
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
