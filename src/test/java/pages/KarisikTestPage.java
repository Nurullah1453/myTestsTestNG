package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KarisikTestPage {

    public KarisikTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement swagLabsUserName;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    public WebElement swagLabsIlkUrun;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement alisverisSepeti;

    public void swagLabsGiris(){

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(swagLabsUserName,"standard_user")
                .sendKeys(Keys.TAB)
                .sendKeys("secret_sauce")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }



}

