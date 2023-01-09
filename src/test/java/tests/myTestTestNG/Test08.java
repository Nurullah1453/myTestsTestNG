package tests.myTestTestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test08 {

    @Test
    public void test(){

        // https://the-internet.herokuapp.com/iframe adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkini tiklayin
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();

        //title'ı "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
        //olan yeni window'a gecis yapın

        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");

        //ve sayfa üzerindeki h1 tagında "Elemental Selenium" yazısı oldugunu test edin

        String expectedYazı="Elemental Selenium";
        String actualYazı=Driver.getDriver().findElement(By.tagName("h1")).getText();

        Assert.assertTrue(expectedYazı.equals(actualYazı));

        Driver.getDriver().quit();
    }


}
