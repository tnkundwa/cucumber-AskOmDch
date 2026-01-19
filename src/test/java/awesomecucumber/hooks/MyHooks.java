package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


public class MyHooks {
    private WebDriver driver;
    private TestContext context;

    public MyHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.initializeDriver("chrome");
        context.driver = driver;
        System.out.println("Before, Thread ID: " + Thread.currentThread().getId() + " Thread name: " + Thread.currentThread().getName() + " Scenario name: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.quit();
        System.out.println("After, Thread ID: " + Thread.currentThread().getId() + " Thread name: " + Thread.currentThread().getName() + " Scenario name: " + scenario.getName());
    }
}