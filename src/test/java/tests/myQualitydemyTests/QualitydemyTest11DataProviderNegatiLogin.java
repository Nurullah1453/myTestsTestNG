package tests.myQualitydemyTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class QualitydemyTest11DataProviderNegatiLogin {
    @DataProvider
    public static Object[][] qdNegatifLoginTesti() {

        Object[][] kullaniciBilgileriArr={{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},
                {"D14","D12345"},{"E15","E12345"}};


        return kullaniciBilgileriArr;
    }

    //Qualitydemy anasayfaya gidin


    //Verilen yanlıs kullanıcı adı ve passvord kombinasyonları icin giris yapılamadıgı test edin

    //Username    Password
    //A11          A12345
    //B12          B12345
    //C13          C12345
    //D14          D12345
    //E15          E12345

    @Test(dataProvider = "qdNegatifLoginTesti")
    
    public void negatifLoginTest(String userName,String password){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage =new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(userName);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        if (qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
        }

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

    }
}
