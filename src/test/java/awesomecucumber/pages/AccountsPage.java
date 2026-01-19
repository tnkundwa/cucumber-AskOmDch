package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {
    @FindBy(id = "reg_username")
    WebElement userNameFld;
    @FindBy(id = "reg_password")
    WebElement passwordFld;
    @FindBy(id = "reg_email")
    WebElement emailFld;
    @FindBy(name = "register")
    WebElement submitBtn;
    @FindBy(tagName = "h1")
    WebElement pageTitle;
    @FindBy(xpath = "//p[contains(text(), 'Hello')]")
    WebElement wlcmMsg;

    //Login
    @FindBy(id = "username")
    WebElement loginUserNameFld;
    @FindBy(id = "password")
    WebElement loginPasswordFld;
    @FindBy(name = "login")
    WebElement loginBtn;
    @FindBy(css = ".woocommerce-error li")
    WebElement errorMsg;

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String userName) {
        userNameFld.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordFld.clear();
        passwordFld.sendKeys(password);
    }

    public void enterEmail(String email) {
        emailFld.sendKeys(email);
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public String getWlcmMsg() {
        wait.until(ExpectedConditions.visibilityOf(wlcmMsg));
        return wlcmMsg.getText();
    }

    //Login
    public void enterLoginUserName(String userName) {
        loginUserNameFld.sendKeys(userName);
    }

    public void enterLoginPassword(String password) {
        loginPasswordFld.sendKeys(password);
    }

    public String getErrorMsg() {
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
