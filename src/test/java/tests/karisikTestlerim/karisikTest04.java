package tests.karisikTestlerim;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.KarisikTestPage;
import utilities.ConfigReader;
import utilities.Driver;

public class karisikTest04 {

    @Test
    public void test(){

        //https://www.saucedemo.com adresine gidin
        KarisikTestPage karisikTestPage=new KarisikTestPage();
        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

        //UserName kutusuna "standard_user" yazdırın
        //password kutusuna "secret_sauce" yazdirin
        //login tusuna basin
        karisikTestPage.swagLabsGiris();

        //Ilk urunun ismini kaydedin ve bu urunun sayfasına gidin
        //Add to cart butonuna basin
        karisikTestPage.swagLabsIlkUrun.click();
        karisikTestPage.addToCartButton.click();


        //alisveris sepetine tiklayin
        karisikTestPage.alisverisSepeti.click();

        //sectiginiz urunun basarili olarak sepete eklendigini control edin
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(karisikTestPage.swagLabsIlkUrun.isDisplayed());


        softAssert.assertAll();


        //sayfayı kapatin
        Driver.closeDriver();



    }
}
