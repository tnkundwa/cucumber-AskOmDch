package awesomecucumber.stepdef;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDef {
    private final WebDriver driver;

    public StoreStepDef(TestContext context) {
        driver = context.driver;
    }

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
//        driver = DriverFactory.getDriver();
        new StorePage(driver).load(MyConstants.STORE);
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        new StorePage(driver).addToCart(product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        new StorePage(driver).addToCart("Blue Shoes");
    }
}
