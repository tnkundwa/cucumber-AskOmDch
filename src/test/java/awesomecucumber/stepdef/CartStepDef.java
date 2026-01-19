package awesomecucumber.stepdef;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDef {
    //    private final WebDriver driver;
    private final CartPage cartPage;

    public CartStepDef(TestContext context) {
//        driver = context.driver;
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
//        CartPage cartPage = new CartPage(driver);
        //Junit
//        Assert.assertEquals("Wrong name my nigga!", product.getName(), cartPage.getProductName());
//        Assert.assertEquals("Wrong number my nigga!", quantity, cartPage.getProductQuantity());
        //TestNg
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
//        driver = DriverFactory.getDriver();
//        new CartPage(driver).goToCheckoutPage();
        cartPage.goToCheckoutPage();
    }
}
