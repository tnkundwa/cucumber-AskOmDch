package awesomecucumber.stepdef;
/*

import awesomecucumber.context.TestContext;
import org.openqa.selenium.WebDriver;

public class AddToCartStepDef {
    private final WebDriver driver;

    public AddToCartStepDef(TestContext context) {
        driver = context.driver;
    }



    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {

    / /        driver = DriverFactory.getDriver();
        new StorePage(driver).load(MyConstants.STORE);
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        new StorePage(driver).addToCart(product.getName());
    }
    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        //Junit
//        Assert.assertEquals("Wrong name my nigga!", product.getName(), cartPage.getProductName());
//        Assert.assertEquals("Wrong number my nigga!", quantity, cartPage.getProductQuantity());
        //TestNg
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

}

     */

