package tests.myTestTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class Test01 {

   @Test
    public void test01(){

       //Amazon anaSayfaya gidin
       Driver.getDriver().get("https://www.amazon.com");
       //"Nutella" için arama yapın
       //WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
       AmazonPage amazonPage=new AmazonPage();

       amazonPage.amazonAramaKutusu.sendKeys("Nutella"+Keys.ENTER);

       //Sonucların Nutella içerdigini test edin


       String expectedKelime="Nutella";
       String actualAramaSonucu=amazonPage.aramaSonucuElementi.getText();

       Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

       Driver.closeDriver();
   }
}
