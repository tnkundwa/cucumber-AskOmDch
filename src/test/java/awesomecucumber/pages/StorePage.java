package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
    @FindBy (css = ".added_to_cart.wc-forward") private WebElement viewCartLink;

    public StorePage(WebDriver driver) {
        super(driver);
    }
    public void addToCart(String productName){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Add “" + productName + "” to your cart']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
