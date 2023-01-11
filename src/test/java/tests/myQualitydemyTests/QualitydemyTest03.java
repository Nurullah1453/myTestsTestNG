package tests.myQualitydemyTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualitydemyTest03 {
    @Test
    public void pozitifLoginTest(){

        //qualtyDemy' anasayaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //login linkine tıklayınız
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUserName"));

        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        if (qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
        }

        ReusableMethods.bekle(3);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());


        Driver.closeDriver();

    }

}
