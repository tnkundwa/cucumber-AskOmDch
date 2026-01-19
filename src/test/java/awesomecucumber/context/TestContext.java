package awesomecucumber.context;

import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Customer;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Customer customer;
}
