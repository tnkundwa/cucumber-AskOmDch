package awesomecucumber.stepdef;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.AccountsPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class StoreStepDef {
    private final WebDriver driver;

    public StoreStepDef(TestContext context) {
        driver = context.driver;
    }

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
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

    @When("I select an option from the dropdown of the browse by category section")
    public void iSelectAnOptionFromTheDropdownOfTheBrowseByCategorySection(List<Map<String, String>> options) {
        new StorePage(driver).categoryOption(options.get(0).get("browseOption"));
        new StorePage(driver).loadCategory(new StorePage(driver).endPoint());
    }

    @Then("I should only see the items that match that category on the page")
    public void iShouldOnlySeeTheItemsThatMatchThatCategoryOnThePage() {
        Assert.assertEquals(1, new StorePage(driver).getSelectedOptionCount());
        Assert.assertEquals(new StorePage(driver).wordsFromOption(), new AccountsPage(driver).getTitle());
    }


    @When("I adjust the price slider by {int} {int}")
    public void iAdjustThePriceSliderBySlideRightSlideLeft(int slideRight, int slideLeft) {
        new StorePage(driver).adjustSliders(slideRight, slideLeft);
    }

    @Then("only the products within the price range are displayed")
    public void onlyTheProductsWithinThePriceRangeAreDisplayed() {
        Assert.assertTrue(new StorePage(driver).allPrices());
    }
}
