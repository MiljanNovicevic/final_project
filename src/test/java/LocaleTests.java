import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {

    @Test
    @Description("Set language to Spanish (ES)")
    public void setLangEs() {
        navPage.getLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading().getText().contains
                        ("Página de aterrizaje"),"Language is not changed");
    }
    @Test
    @Description("Set language to English (EN)")
    public void setLangEn() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading().getText().contains
                        ("Landing"),"Language is not changed");
    }
    @Test
    @Description("Set language to Chinese (CN)")
    public void setLangCn() {
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading().getText().contains
                        ("首页"),"Language is not changed");
    }
    @Test
    @Description("Set language to French (FR)")
    public void setLangFr() {
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading().getText().contains
                        ("Page d'atterrissage"),"Language is not changed");
    }
}
