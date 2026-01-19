package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing_first_name")
    private WebElement billingFirstnameFld;
    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1")
    private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city")
    private WebElement billingCityFld;
    @FindBy(id = "billing_state")
    private WebElement billingStateDropDown;
    @FindBy(id = "select2-billing_state-container")
    private WebElement alternateBillingStateDropDown;
    @FindBy(id = "billing_postcode")
    private WebElement billingZipFld;
    @FindBy(id = "billing_email")
    private WebElement billingEmailFld;
    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeTxt;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstnameFld));
        if (e != null) {
            e.clear();
        }
        if (e != null) {
            e.sendKeys(billingFirstName);
        }
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        Objects.requireNonNull(e).clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        assert e != null;
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        billingCityFld.clear();
        billingCityFld.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingState(String billingStateName) {
//        alternateBillingStateDropDown.click();
//        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//li[text()='" + billingStateName + "']")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
//        assert null != e;
//        e.click();

//        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        Select select = new Select(Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown))));
        select.selectByVisibleText(billingStateName);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip) {
        billingZipFld.clear();
        billingZipFld.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail) {
        billingEmailFld.clear();
        billingEmailFld.sendKeys(billingEmail);
        return this;
    }

    //    public CheckoutPage setBillingDetails(String billingFirstName, String billingLastName, String billingAddressOne,
//                                          String billingCity, String billingStateName, String billingZip,
//                                          String billingEmail) {
//        return enterBillingFirstName(billingFirstName).
//                enterBillingLastName(billingLastName).
//                enterBillingAddressLineOne(billingAddressOne).
//                enterBillingCity(billingCity).
//                selectBillingState(billingStateName).
//                enterBillingZip(billingZip).
//                enterBillingEmail(billingEmail);
//    }
    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterBillingAddressLineOne(billingDetails.getBillingAddressOne()).
                enterBillingCity(billingDetails.getBillingCity()).
                selectBillingState(billingDetails.getBillingStateName()).
                enterBillingZip(billingDetails.getBillingZip()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckoutPage placeOrder() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockOverlay")));
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn))).click();
        /*
        or you can also use js and get rid of the wait
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
        driver.findElement(placeOrderBtn));
         */

        return this;
    }

    public String getNotice() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(noticeTxt))).getText();
    }

}
