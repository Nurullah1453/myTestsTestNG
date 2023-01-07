package tests.myTestTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualtydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test04 {

    @Test
    public void test(){

        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // 2- login linkine basin
        QualtydemyPage qualtydemyPage=new QualtydemyPage();
        qualtydemyPage.ilkLoginLinki.click();

        // 3- Kullanici email'i olarak valid email girin
        qualtydemyPage.kullanıcıEmailKutusu.sendKeys("user_1106147@login.com");

        // 4- Kullanici sifresi olarak valid sifre girin
        qualtydemyPage.passwordKutusu.sendKeys("31488081");

        qualtydemyPage.cookieBir.click();
        ReusableMethods.bekle(3);

        // 5- Login butonuna basarak login olun
       qualtydemyPage.loginButonu.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualtydemyPage.basarılıGirisCoursesLink.isDisplayed());

        Driver.closeDriver();

    }
}
