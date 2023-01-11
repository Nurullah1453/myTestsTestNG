package tests.myAmazonTests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public class AmazonTest01 {

    @Test
    public void test(){

        //amazon anasayfaya gidin.
        Driver.getDriver().get("https://www.amazon.com");

        //amazon anasayfaya gitiğinizi dogrulayın
        SoftAssert softAssert=new SoftAssert();
        String expectedUrlKelime="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"amazon kelimesi bulunamadı");

        //nutella aratın
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuclarının nutella içerdigini dogrulayın
        String aramaSonucYazısı=amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazısı.contains("Nutella"),"arama sonucları nutella içermiyor");

        //java aratın
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java"+Keys.ENTER);

        //arama sonuclarının 1000'den fazla oldugunu dogrulayın.
        //1-48 of over 7,000 results for "Java"

        aramaSonucYazısı=amazonPage.aramaSonucuElementi.getText();

        String[]sonucArr=aramaSonucYazısı.split(" ");
        //[1-48, of, over, 7,000, results, for, "Java"]

        String javaSonucSayısıStr=sonucArr[3]; //7,000
        javaSonucSayısıStr=javaSonucSayısıStr.replaceAll("\\W","");

        int sonucSayısıInt=Integer.parseInt(javaSonucSayısıStr);

        softAssert.assertTrue(sonucSayısıInt>1000,"sonuc sayısı 1000'den küçük");


        softAssert.assertAll();
        Driver.closeDriver();
    }
}
