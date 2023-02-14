import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CitiesTests extends BaseTest {

    @Test
    @Description("Visit admin cities page and list cities")
    public void adminCitiesPageAndList() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),"Not on admin cities page");
    }
    @Test
    @Description("Check input types for create/edit new city")
    public void checkInputTypeForNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemDialog();
        Assert.assertEquals(citiesPage.getNameInput().getAttribute("type"), "text", "Wrong input type");
        citiesPage.getCancelButton().click();
    }
    @Test
    @Description("Create new city")
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemDialog();
        citiesPage.getNameInput().sendKeys("Jagodina");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage().getText().contains("Saved successfully"),
                "Message is not correct");
    }
    @Test
    @Description("Edit city")
    public void editCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Jagodina");
        citiesPage.waitForNumberOfRowsToBe(1);
        Thread.sleep(3000);
        citiesPage.getEditButtonByRow(1).click();
        citiesPage.getNameInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.getNameInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.getNameInput().sendKeys("Jagodina v2");
        Thread.sleep(500);
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage().getText().contains("Saved successfully"),
                "Message is not correct");
    }
    @Test
    @Description("Search city")
    public void searchCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput()
                .sendKeys("Jagodina");
        citiesPage.waitForNumberOfRowsToBe(1);
        Thread.sleep(3000);
        Assert.assertEquals(citiesPage.getCellByRowAndColumn(1, 2).getText(),
                "Jagodina",
                "City is not correct");
    }
    @Test
    @Description("Delete city")
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Jagodina v2");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage.getCellByRowAndColumn(1, 2).getText(),
                "Jagodina",
                "Wrong city");
        citiesPage.getDeleteButtonByRow(1).click();
        citiesPage.waitForDeleteDialog();
        citiesPage.getDeleteButton().click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage().getText().contains("Deleted successfully"),
                "Wrong message");
    }
}
