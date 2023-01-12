package tests.myAmazonTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class AmazonTest06SS extends TestBaseRapor {

    @Test
    public void test(){

        //Rapolayıp Testi Failed yapıp ekran fotografı alın

        extentTest=extentReports.createTest("Nutella Testi","Kullanıcı amazonda nutella arayabilmeli");


        //Amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");

        //Nutella aratalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Arama kutusuna nutella yazıp arama yapıldı");

        //Sonucların Java icerdigini test edelim
        String actualKelime=amazonPage.aramaSonucuElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("Arama sonucları kaydedildi ");

        Assert.assertTrue(actualKelime.contains(expectedKelime));
        extentTest.pass("Arama sonuclarının nutella icerdigi tes edildi");


    }




}

