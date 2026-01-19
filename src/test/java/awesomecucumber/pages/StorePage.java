package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class StorePage extends BasePage {
    @FindBy(css = ".added_to_cart.wc-forward")
    private WebElement viewCartLink;
    @FindBy(id = "product_cat")
    private WebElement productCatDropDown;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Add “" + productName + "” to your cart']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }

    public Select productCatSelect() {
        return new Select(productCatDropDown);
    }

    public void categoryOption(String option) {
        productCatSelect().selectByVisibleText(option);
    }

    public List<String> getSelectedOption() {
        return productCatSelect().getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int getSelectedOptionCount() {
        return productCatSelect().getAllSelectedOptions().size();
    }
}
