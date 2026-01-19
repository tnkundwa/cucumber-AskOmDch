package awesomecucumber.stepdef;

import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class CheckoutStepDef {
    //    private final WebDriver driver;
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutStepDef(TestContext context) {
        this.context = context;
//        driver = context.driver;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

//    @Given("I'm a guest customer")
//    public void iMAGuestCustomer() {

    /// /        driver = DriverFactory.getDriver();
//        new StorePage(driver).load(EndPoint.STORE.url);
//    }

//    @And("I have a product in the cart")
//    public void iHaveAProductInTheCart() {
//        new StorePage(driver).addToCart("Blue Shoes");
//    }
//    @And("I'm on the Checkout page")
//    public void iMOnTheCheckoutPage() {

    /// /        driver = DriverFactory.getDriver();
//        new CartPage(driver).goToCheckoutPage();
//    }
    @When("I provide billing details")
    public void iProvideBillingDetails() {
//        CheckoutPage checkoutPage = new CheckoutPage(driver);
//        checkoutPage.setBillingDetails(billingDetails.get(0).get("firstname"),
//                billingDetails.get(0).get("lastname"),
//                billingDetails.get(0).get("address_line1"),
//                billingDetails.get(0).get("city"),
//                billingDetails.get(0).get("state"),
//                billingDetails.get(0).get("zip"),
//                billingDetails.get(0).get("email"));
        checkoutPage.setBillingDetails(context.billingDetails);
    }

//    @And("my billing details are")
//    public void myBillingDetailsAre(BillingDetails billingDetails) {
//        this.billingDetails = billingDetails;
//    }

    @And("I place an order")
    public void iPlaceAnOrder() {
//        new CheckoutPage(driver).placeOrder();
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
//        Assert.assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).getNotice());
//        Assert.assertEquals(new CheckoutPage(driver).getNotice(), "Thank you. Your order has been received.");
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

}
