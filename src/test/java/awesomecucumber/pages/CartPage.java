package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class CartPage extends BasePage{
    @FindBy(css = ".product-name a")
    private WebElement productNameFld;
    @FindBy(css = "input[type = 'number']")
    private WebElement productQuantityFld;
    @FindBy(css = ".checkout-button")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return productNameFld.getText();
    }
    public int getProductQuantity(){
        return (Integer.parseInt(Objects.requireNonNull(productQuantityFld.getAttribute("value"))));
    }
    public void goToCheckoutPage(){
        checkoutBtn.click();
    }
}
