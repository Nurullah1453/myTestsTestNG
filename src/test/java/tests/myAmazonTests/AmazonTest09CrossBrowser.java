package tests.myAmazonTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class AmazonTest09CrossBrowser extends TestBaseCross {

    @Test
    public void test01(){

        //wisequarter anasayfaya gidelim
        driver.get("https://wisequarter.com/");

        //wisequarter sitesine gittimizi test edelim

        String actualUrl= driver.getCurrentUrl();
        String expectedKelime="wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedKelime));


    }
}