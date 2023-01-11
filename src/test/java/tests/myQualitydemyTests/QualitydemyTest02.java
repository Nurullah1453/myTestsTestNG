package tests.myQualitydemyTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualitydemyTest02 {

    //3 test methodu oluşturun
    //1.de yanlıs email,dogru sifre
    //2.de dogru email,yanlıs sifre
    //3.de yanlıs email, yanlıs sifre ile giriş yapmayı deneyin
    //ve giriş yapılamadıgını test edin.


    @Test
    public void yanlisEmailTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualitydemyPage qualtydemyPage=new QualitydemyPage();
        qualtydemyPage.ilkLoginLinki.click();
        qualtydemyPage.kullaniciEmailKutusu.sendKeys("test01@gmail.com");
        qualtydemyPage.passwordKutusu.sendKeys("31488081");
        qualtydemyPage.cookie.click();
        ReusableMethods.bekle(3);
        qualtydemyPage.loginButonu.click();

        Assert.assertTrue(qualtydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlisPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualitydemyPage qualtydemyPage=new QualitydemyPage();
        qualtydemyPage.ilkLoginLinki.click();
        qualtydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        qualtydemyPage.passwordKutusu.sendKeys("test123");
        qualtydemyPage.cookie.click();
        ReusableMethods.bekle(3);
        qualtydemyPage.loginButonu.click();

        Assert.assertTrue(qualtydemyPage.kullaniciEmailKutusu.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void yanlısEmailSifre(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualitydemyPage qualtydemyPage=new QualitydemyPage();
        qualtydemyPage.ilkLoginLinki.click();
        qualtydemyPage.kullaniciEmailKutusu.sendKeys("test@gmail.com");
        qualtydemyPage.passwordKutusu.sendKeys("test123");
        qualtydemyPage.cookie.click();
        ReusableMethods.bekle(3);
        qualtydemyPage.loginButonu.click();

        Assert.assertTrue(qualtydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }
}
