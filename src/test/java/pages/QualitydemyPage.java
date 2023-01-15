package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualitydemyPage {

    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")
    public WebElement kullaniciEmailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(linkText = "My courses")
    public WebElement basariliGirisCoursesLinki;

    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement cookie;

    @FindBy(xpath = "//span[text()='Categories']")
    public WebElement categories;

    @FindBy(xpath = "//span[text()='All courses']")
    public WebElement allCourses;

    @FindBy(xpath = "//a[text()='2']")
    public WebElement secondPage;

    @FindBy(xpath = "(//a[@class='course-title'])[4]")
    public WebElement theEnglishMaster;

    @FindBy(xpath = "//button[text()='Buy now']")
    public WebElement buyNowButton;

    @FindBy(xpath = "//button[text()='Checkout']")
    public WebElement checkOutButton;

    @FindBy(xpath = "//img[@class='payment-gateway-icon']")
    public WebElement sprite;

    @FindBy(xpath = "//*[text()='Pay with stripe']")
    public WebElement payWithStripeButton;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement odemeEmailKutusu;

    @FindBy(xpath = "//div[@class='SubmitButton-IconContainer']")
    public WebElement payButton;

    @FindBy(xpath = "//footer[@class='footer-area d-print-none mt-5 pt-5']")
    public WebElement footer;

    public void odemeBilgileri(){

        Actions actions=new Actions(Driver.getDriver());

        odemeEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("qdGecerliKartNo"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("qdKartTarih"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("qdKartCV"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("qdKartIsmi"))
                .sendKeys(Keys.TAB).sendKeys("Türkiye").perform();
       payButton.click();
        ReusableMethods.bekle(5);



    }


}