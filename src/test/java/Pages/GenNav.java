package Pages;

import Utilities.GWD_old;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenNav extends ParentPage{

    public GenNav() {
        PageFactory.initElements(GWD_old.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement register;

    @FindBy(xpath = "//div[@id='leftPanel']/p/b")
    public WebElement titleWelcome;

    @FindBy(xpath = "//div[@id='leftPanel']/h2")
    public WebElement customerLogin;

    @FindBy(xpath = "//div[@id='rightPanel']/h1")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[text()='Bill Pay']")
    public WebElement billpay;

    @FindBy(xpath = "//a[text()='Transfer Funds']")
    public WebElement transferfunds;

    @FindBy(xpath = "//input[@id='amount']")
    public WebElement amount;

    @FindBy(xpath = "//input[@class='button']")
    public WebElement trnsferbutton;

    @FindBy(xpath = "//span[@id='fromAccountId']")
    public WebElement accountid;

    @FindBy(xpath = "//a[text()='Accounts Overview']")
    public WebElement accountoverview;

    @FindBy(xpath = "//a[class='ng-binding']")
    public WebElement accountnumber;

    @FindBy(xpath = "//tr[class='ng-scope']/td")
    public WebElement date;

    @FindBy(xpath = "//td[class='ng-binding ng-scope']")
    public WebElement credit;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    public WebElement fromaccount;

    @FindBy(xpath = "//select[@id='toAccountId']")
    public WebElement toaccount;

    @FindBy(xpath = "//a[text()='Open New Account']")
    public WebElement oNewAccount;

    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "register": return this.register;
            case "titleWelcome": return this.titleWelcome;

        }
        return null;
    }




}
