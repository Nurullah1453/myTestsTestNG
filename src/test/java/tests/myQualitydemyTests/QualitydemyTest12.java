package tests.myQualitydemyTests;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualitydemyTest12 {

    @Test

    public void test(){


        //Qualitydemy web sayfasına gidin
        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //cookies'i kabul edin
        if (qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
        }

        //login linkine tıklayın
        qualitydemyPage.ilkLoginLinki.click();

        //email ve password bilgilerini girerek login butonuna tıklayın
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliSifrem"));
        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(5);

        //categories dropDown'dan all courses secenegine tıklayın
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(qualitydemyPage.categories)
                .clickAndHold(qualitydemyPage.categories)
                .click(qualitydemyPage.allCourses)
                .perform();

        //acilan sayfada olan derslerden The English Master Course dersine tıklayın
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(10);
        qualitydemyPage.secondPage.click();
        ReusableMethods.bekle(3);

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        qualitydemyPage.theEnglishMaster.click();



        //dersi satin almak icin buy now secenegine ve checkout butonuna tıklayın
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        qualitydemyPage.buyNowButton.click();
        ReusableMethods.bekle(1);
        qualitydemyPage.checkOutButton.click();


        //stripe secenegini secerek pay with spripe e tiklayin
        qualitydemyPage.sprite.click();
        qualitydemyPage.payWithStripeButton.click();
        ReusableMethods.bekle(2);

        //Email-card information gun ay yıl cv ve name on card bilgilerini doldurarak pay a tiklayin
        qualitydemyPage.odemeBilgileri();


        Driver.closeDriver();



    }

}
