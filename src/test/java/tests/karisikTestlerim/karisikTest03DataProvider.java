package tests.karisikTestlerim;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class karisikTest03DataProvider {


    @DataProvider
    public static Object[][] aranacakKelimeler() {

        Object[][] kelimelerArrayi={{"elma"},{"armut"},{"portakal"}};


        return kelimelerArrayi;
    }

    //Amazon anasayfaya gidip arama search textbox'ta
    //Elma, armut portakal aratalım

    @Test(dataProvider = "aranacakKelimeler")

    public void test(String kelimelerArrayi){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys(kelimelerArrayi+Keys.ENTER);


    }
}
