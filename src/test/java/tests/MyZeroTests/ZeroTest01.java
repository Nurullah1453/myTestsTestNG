package tests.MyZeroTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZeroTest01 {

    @Test
    public void test(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage=new ZeroWebAppPage();
        zeroWebAppPage.signInButonu.click();

        // 3. Login kutusuna “username” yazin
        zeroWebAppPage.userNameKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        zeroWebAppPage.userPasswordKutusu.sendKeys("password");

        // 5. Sign in tusuna basin
        zeroWebAppPage.singInSubmitButonu.click();
        Driver.getDriver().navigate().back();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebAppPage.onlineBanking.click();
        zeroWebAppPage.payBills.click();

        // 7. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseFCButonu.click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroWebAppPage.currencDropDown);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String actualDropDownSecim=select.getFirstSelectedOption().getText();
        String expectedDropDownSecim="Eurozone (euro)";

        softAssert.assertEquals(actualDropDownSecim,expectedDropDownSecim,"Eurozone testi FAILED");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
        // "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
        // "Thailand (baht)"

        List<WebElement> optionsElementListesi=select.getOptions();
        List<String>actualOptinsListesiStr=new ArrayList<>();

        for (WebElement each:optionsElementListesi
             ) {
            actualOptinsListesiStr.add(each.getText());
        }

        String[]arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
                "Thailand (baht)"};


        List<String>expectedOptionsListesi= Arrays.asList(arr);

        Collections.sort(actualOptinsListesiStr);
        Collections.sort(expectedOptionsListesi);

        softAssert.assertEquals(actualOptinsListesiStr,expectedOptionsListesi);

        softAssert.assertAll();
        Driver.closeDriver();
    
    }
}
