import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    @Description("Forbid visits to home url if not authenticated")
    public void forbidVisitsToHome() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Unauthorised/unauthenticated visit to the home URL");
    }
    @Test
    @Description("Forbid visits to profile url if not authenticated")
    public void forbidVisitsToProfile() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Unauthorised/unauthenticated visit to the profile URL");
    }
    @Test
    @Description("Forbid visits to admin cities url if not authenticated")
    public void forbidVisitsToAdminCities() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Unauthorised/unauthenticated visit to the admin cities view");
    }
    @Test
    @Description("Forbid visits to admin users url if not authenticated")
    public void forbidVisitsToAdminURLs() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Unauthorised/unauthenticated visit to the admin accessable URLs");
    }
}
