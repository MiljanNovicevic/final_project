import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    @Description("Visit login page")
    public void visitLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Not on login page");
    }

    @Test
    @Description("Check input types")
    public void checkInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),"email",
                "Wrong input type");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),"password",
                "Wrong input type");
    }
    @Test
    @Description("Display error when user does not exist")
    public void errorWhenUserDoesNotExist() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForErrorPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(),
                "User does not exists",
                "Wrong error message");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Not on login page");
    }

    @Test
    @Description("Display error when password is wrong")
    public void wrongPasswordError() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForErrorPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(),
                "Wrong password",
                "Error message not as expected");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Not a log in page");
    }
    @Test
    @Description("Login")
    public void loggingIn() throws InterruptedException {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(500);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),"Unsuccessful log in - not on home page");
    }
    @Test
    @Description("Logout")
    public void loggingOut() {
        navPage.getLogoutButton().click();
    }

}
