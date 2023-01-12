package tests.myAmazonTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonTest07DataProvider {

    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {


        Object[][] amazonAranacakKelimelerArrayi={{"Nutella"}, {"java"}, {"apple"}, {"samsung"}, {"klavye"}};

        return amazonAranacakKelimelerArrayi;
    }

    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){

        //Amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, java, apple, samsung, klavye kelimeri icin arama yapalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);


        //sonucların bu kelimeri icerdigini test edelim
        String actualSonucYazısı=amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazısı.contains(aranacakKelime));


    }
}
