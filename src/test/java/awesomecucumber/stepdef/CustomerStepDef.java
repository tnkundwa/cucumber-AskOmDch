package awesomecucumber.stepdef;

import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDef {
    private final WebDriver driver;
    private final TestContext context;

    public CustomerStepDef(TestContext context) {
        this.context = context;
        driver = context.driver;
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        new StorePage(driver).load(EndPoint.STORE.url);
    }
}
