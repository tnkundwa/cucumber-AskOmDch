package awesomecucumber.stepdef;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartStepDef {
    private final CartPage cartPage;

    public CartStepDef(TestContext context) {
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        cartPage.goToCheckoutPage();
    }
}
