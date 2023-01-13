package tests.myAmazonTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class AmazonTest08CrossBrowser extends TestBaseCross {

    @Test
    public void test(){

        //Bu classdaki testi ve AmazonTest09CrossBrowser testini crossBrowser ile calistiralım
        //Bunun icin CrossBrowserSiraliCalistirma.xml file' inceleyiniz

        //Amazon anasayfaya gidelim
        driver.get(ConfigReader.getProperty("amazonUrl"));

        //Arama Kutusuna Nutella yazıp aratalım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //Sonucların nutella icerdigini test edelim
        WebElement aramaSonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualKelime=aramaSonucYaziElementi.getText();
        String expectedKelime="Nutella";

        Assert.assertTrue(actualKelime.contains(expectedKelime));

    }
}
