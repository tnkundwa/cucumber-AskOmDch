package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    //filter
    @FindBy(className = "ui-slider-handle")
    private List<WebElement> sliders;
    @FindBy(xpath = ".//button[text() = 'Filter']")
    private WebElement filterButton;
    @FindBy(css = ".price_label .from")
    private WebElement priceLabelFrom;
    @FindBy(css = ".price_label .to")
    private WebElement priceLabelTo;
    @FindBy(css = "[class='price'] bdi")
    private List<WebElement> allItems;

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

    public void categoryOption(String value) {
        productCatSelect().selectByValue(value);
    }

    public List<String> getSelectedOption() {
        return productCatSelect().getAllSelectedOptions().stream().map(e -> e.getText().replace('\u00A0', ' ').trim()).collect(Collectors.toList());
    }

    public int getSelectedOptionCount() {
        return productCatSelect().getAllSelectedOptions().size();
    }

    public String endPoint() {
        return getSelectedOption().get(0).toLowerCase().replaceAll(" ", "-").replaceAll("[^a-z-]", "");
    }

    public String wordsFromOption() {
        return getSelectedOption().get(0).replaceAll("[^a-zA-Z']", "");
    }

    //filter
    public WebElement getLeftSlider() {
        return sliders.get(0);
    }

    public WebElement getRightSlider() {
        return sliders.get(1);
    }

    public double getPriceFrom() {
        return Double.parseDouble(priceLabelFrom.getText().substring(1));
    }

    public double getPriceTo() {
        return Double.parseDouble(priceLabelTo.getText().substring(1));
    }

    public void adjustSliders(int slideRight, int slideLeft) {
        for (int i = 0; i < slideRight; i++) {
            getLeftSlider().sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i < slideLeft; i++) {
            getRightSlider().sendKeys(Keys.ARROW_LEFT);
        }
        filterButton.click();
    }

    public boolean allPrices() {
        List<Double> allItemsPrices = allItems.stream().map(e -> Double.parseDouble(e.getText().substring(1))).collect(Collectors.toList());
        return allItemsPrices.stream().allMatch(n -> n >= getPriceFrom() && n <= getPriceTo());
    }

}
