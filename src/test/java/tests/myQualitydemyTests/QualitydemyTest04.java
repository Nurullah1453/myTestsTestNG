package tests.myQualitydemyTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualitydemyTest04 {

    QualitydemyPage qualitydemyPage=new QualitydemyPage();
    @Test
    public void yanlısEmail(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        if (qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
        }
        ReusableMethods.bekle(3);
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void yanlısPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        if (qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
        }
        ReusableMethods.bekle(3);
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUserName"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlısEmailPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        if (qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
        }
        ReusableMethods.bekle(3);
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Driver.closeDriver();

    }
}
