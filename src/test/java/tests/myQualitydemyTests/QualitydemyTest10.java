package tests.myQualitydemyTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualitydemyTest10 {

    //3 test method'u olusturun
    //1.de yanlis email, dogru sifre
    //2.de dogru email yanlis sifre
    //3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    //giris yapilamadigini test edin

    QualitydemyPage qualitydemyPage=new QualitydemyPage();
    @Test
    public void yanlısEmail(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUserName"));
        qualitydemyPage.passwordKutusu.sendKeys("qdGecerliPassword");
        ReusableMethods.bekle(3);
        qualitydemyPage.cookie.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlısPassword() {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUserName"));
        qualitydemyPage.passwordKutusu.sendKeys("qdGecersizPassword");
        ReusableMethods.bekle(3);
        qualitydemyPage.cookie.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void qdGecersizPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUserName"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        ReusableMethods.bekle(3);
        qualitydemyPage.cookie.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();


    }
}
