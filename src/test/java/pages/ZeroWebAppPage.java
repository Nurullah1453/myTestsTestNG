package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import utilities.Driver;

public class ZeroWebAppPage {

    public ZeroWebAppPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement signInButonu;

    @FindBy(id = "user_login")
    public WebElement userNameKutusu;

    @FindBy(id = "user_password")
    public WebElement userPasswordKutusu;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement singInSubmitButonu;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBanking;

    @FindBy(id = "pay_bills_link")
    public WebElement payBills;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseFCButonu;

    @FindBy(id = "pc_currency")
    public WebElement currencDropDown;


}
