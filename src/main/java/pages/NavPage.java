package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//span[text()='Home']"));
    }

    public WebElement getAboutLink(){
        return driver.findElement(By.xpath("//span[text()=' About ']"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//span[text()=' Login ']"));
    }

    public WebElement getSignupButton(){
        return driver.findElement(By.xpath("//span[text()=' Sign Up ']"));
    }

    public WebElement getMyProfileLink(){
        return driver.findElement(By.className("btnProfile"));
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesLink(){
        return driver.findElement(By.className("btnAdminCities"));
    }

    public WebElement getUsersLink(){
        return driver.findElement(By.className("btnAdminUsers"));
    }

    public WebElement getLogoutButton(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnLogout")));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnglishLanguageButton(){
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getSpanishLanguageButton(){
        return driver.findElement(By.className("btnES"));
    }

    public WebElement getFrenchLanguageButton(){
        return driver.findElement(By.className("btnFR"));
    }

    public WebElement getChineseLanguageButton(){
        return driver.findElement(By.className("btnCN"));
    }

    public WebElement getLandingPageHeading(){
        return driver.findElement(By.tagName("h1"));
    }

}
