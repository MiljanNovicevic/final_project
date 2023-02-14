import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test
    @Description("Visits signup page")
    public void visitSignupPage() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Not on the signup page");
    }
    @Test
    @Description("Checks input types")
    public void checkInputTypes() {
        navPage.getSignupButton().click();
        Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"),"email",
                "Wrong input type");
        Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"),"password",
                "Wrong input type");
        Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "Wrong input type");
    }
    @Test
    @Description("Displays error when user already exists")
    public void errorUserAlreadyExists() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),"Not on the signup page");
        signupPage.getNameInput().sendKeys("Another User");
        signupPage.getEmailInput().sendKeys("admin@admin.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForErrorPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(),
                "E-mail already exists",
                "Wrong error message");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),"Not on signup page");
    }
    @Test
    @Description("Signup")
    public void signup() throws InterruptedException {
        navPage.getSignupButton().click();
        signupPage.getNameInput().sendKeys("Miljan Novicevic");
        signupPage.getEmailInput().sendKeys("miljan@mail.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForVerifyYourAccountDialog();
        Thread.sleep(1000);
        Assert.assertEquals(messagePopUpPage.getVerifyAccountHeader().getText(),
                "IMPORTANT: Verify your account",
                "Wrong message");
        messagePopUpPage.getVerifyAccountCloseButton().click();
        navPage.getLogoutButton().click();
    }

}
