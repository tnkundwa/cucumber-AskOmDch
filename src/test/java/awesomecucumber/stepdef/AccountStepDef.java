package awesomecucumber.stepdef;

import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Customer;
import awesomecucumber.pages.AccountsPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountStepDef {
    private final AccountsPage accountsPage;
    private final TestContext context;

    public AccountStepDef(TestContext context) {
        accountsPage = PageFactoryManager.getAccountsPage(context.driver);
        this.context = context;
    }

    @Given("I'm at the Accounts Page")
    public void iMAtTheAccountsPage() {
        accountsPage.load(EndPoint.ACCOUNTS.url);
    }

    @When("I sign up with valid credentials")
    public void iSignUpWithValidCredentials(Customer customer) {
        context.customer = customer;
        accountsPage.enterUserName(customer.getUsername());
        accountsPage.enterEmail(customer.getEmail());
        accountsPage.enterPassword(customer.getPassword());
        accountsPage.clickSubmitBtn();
    }

    @Then("I should be taken to the accounts page of my personal account")
    public void iShouldBeTakenToTheAccountsPageOfMyPersonalAccount() {
        Assert.assertEquals("Wrong title!", "Account", accountsPage.getTitle());
    }

    @And("I should receive a successful message")
    public void iShouldReceiveASuccessfulMessage() {
        Assert.assertTrue(accountsPage.getWlcmMsg().contains("Hello " + context.customer.getUsername()));
    }

    @When("I use login in with valid credentials")
    public void iUseLoginInWithValidCredentials(Customer customer) {
        context.customer = customer;
        accountsPage.enterLoginUserName(customer.getUsername());
        accountsPage.enterLoginPassword(customer.getPassword());
        accountsPage.clickLoginBtn();
    }

    @When("I use login in with invalid username")
    public void iUseLoginInWithInvalidUsername(Customer customer) {
        context.customer = customer;
        accountsPage.enterLoginUserName(customer.getUsername());
        accountsPage.enterLoginPassword(customer.getPassword());
        accountsPage.clickLoginBtn();
    }

    @When("I use login in with invalid password")
    public void iUseLoginInWithInvalidPassword(Customer customer) {
        context.customer = customer;
        accountsPage.enterLoginUserName(customer.getUsername());
        accountsPage.enterLoginPassword(customer.getPassword());
        accountsPage.clickLoginBtn();
    }

    @Then("the login should fail and I should receive a invalid username error message")
    public void theLoginShouldFailAndIShouldReceiveAInvalidUsernameErrorMessage() {
        Assert.assertTrue(accountsPage.getErrorMsg().trim().contains("The username " + context.customer.getUsername() + " is not registered on this site. If you are unsure of your username, try your email address instead."));
    }

    @Then("the login should fail and I should receive a invalid password error message")
    public void theLoginShouldFailAndIShouldReceiveAInvalidPasswordErrorMessage() {
        Assert.assertTrue(accountsPage.getErrorMsg().trim().contains("The password you entered for the username " + context.customer.getUsername() + " is incorrect."));
    }

}
