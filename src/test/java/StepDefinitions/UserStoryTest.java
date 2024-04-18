
package StepDefinitions;

import Pages.DialogContent;
import Pages.GenNav;
import Pages.LoanFeature;
import Pages.ParentPage;
import Utilities.GWD_old;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class UserStoryTest {

    public static class TC_01_RegisterSteps {
    GenNav gn=new GenNav();
    DialogContent dc=new DialogContent();


    @Given("User navigate to the ParaBank Website")
    public void userNavigateToTheParabankWebsite() {
        GWD_old.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
    }


    @When("User clicks the Register link")
    public void userClicksTheRegisterLink() {
       gn.myClick(gn.register);

    }

    @And("the user fills the fields on the screen")
    public void theUserFillsTheFieldsOnTheScreen(DataTable registerFields) {
        List<List<String>> listTxtYazi = registerFields.asLists(String.class);

        for (int i = 0; i < ((List<?>) listTxtYazi).size(); i++) {
            WebElement txtBoxWebElement = dc.getWebElement(listTxtYazi.get(i).get(0));
            dc.mySendKeys(txtBoxWebElement, listTxtYazi.get(i).get(1));
        }
    }

    @And("the user clicks the Register button")
    public void theUserClicksTheRegisterButton() {
            dc.myClick(dc.registerButton);
        }


    @Then("user confirms that a successful registration process has taken place")
    public void userConfirmsThatASuccessfulRegistrationProcessHasTakenPlace() {
        gn.verifyContainsText(gn.titleWelcome,"Welcome");

        }
    }
    public static class TC_02_Login1 {
    GenNav gn=new GenNav();
    DialogContent dc=new DialogContent();

    @And("the user sees the Customer Login section on the home page.")
    public void theUserSeesTheCustomerLoginSectionOnTheHomePage() {
        gn.verifyContainsText(gn.customerLogin,"Customer Login");
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        dc.myClick(dc.loginButton);
    }

    @Then("The user confirms the error message that appears on the screen.")
    public void theUserConfirmsTheErrorMessageThatAppearsOnTheScreen() {
        gn.verifyContainsText(gn.errorMessage,"Error");
    }
    }
    public static class TC_03_InvoicePayment {
    GenNav gn = new GenNav();
    DialogContent dc = new DialogContent();

    @And("Select Payment option")
    public void selectPaymentOption() {
        dc.SelectMenu(dc.selectAccount,0);
    }


    @When("the user clicks the Bill Pay option from the menu on the website")
    public void theUserClicksTheBillPayOptionFromTheMenuOnTheWebsite() {
        gn.myClick(gn.billpay);
    }

    @And("the user clicks the Send Payment button for payment process")
    public void theUserClicksTheSendPaymentButtonForPaymentProcess() {
        dc.myClick(dc.sendpaymentButton);
    }
    }
    public static class TC_04_NewAccount {
    GenNav gn=new GenNav();
    DialogContent dc = new DialogContent();
    @When("User clicks open new Account")
    public void userClicksOpenNewAccount() {
        gn.myClick(gn.oNewAccount);
    }

    @Then("the User click on the Open new Account button")
    public void theUserClickOnTheOpenNewAccountButton() {
        dc.ActionHover(dc.sendpaymentButton);
        dc.myClick(dc.sendpaymentButton);
    }
    }
    public static class TC_06_MoneyTransfer {
    GenNav gn=new GenNav();
    DialogContent dc = new DialogContent();
    ParentPage pr=new ParentPage();


    @When("User clicks open Transfer Funds")
    public void UserclicksopenTransferFunds()  {gn.myClick(gn.transferfunds);}
    @And("User chooses sender and receiver account")
    public void userchosessenderandreceiveraccount() {pr.SelectMenu(gn.fromaccount, 0);
        pr.SelectMenu(gn.toaccount,1);}
    @And("User clicks Transfer button")
    public void userclickstransferbutton ()  {gn.myClick(gn.trnsferbutton);}

    @Then("User verifies Transfer funds")
    public void thenuserverifiestransferfunds() {gn.verifyContainsText(gn.accountid, "1137");}
    @And("User clicks  Accounts Overview")
    public void userclicksaccountoverview() {gn.myClick(gn.accountoverview);}

    @And("User clics Account Number")
    public void userclicksaccountnumber() {gn.myClick(gn.accountnumber);}
    @Then("User verifies transfer date and Amount in account")
    public void userverifiestransferdateandAmountinaccount() {
        gn.verifyContainsText(gn.date, "04-10-2024");

        gn.verifyContainsText(gn.credit,"100");
    }
    }
    public static class TC_08_LoanApplication {
    LoanFeature lf = new LoanFeature();

    private String accountNumber;

    @And("user click on {string} link")
    public void userClickOnLink(String linkText) {
        WebElement requestLoanLink = lf.getWebElement(linkText);
        lf.myClick(requestLoanLink);
    }

    @And("user enters $ {string} in the loan amount field")
    public void userEntersInTheField(String amount) {
        lf.mySendKeys(lf.loanAmount, amount);
    }

    @And("user enters {string} dollars in Down Payment field")
    public void userEntersDollarsInField(String amount) {
        lf.mySendKeys(lf.downPayment, amount);
    }

    @And("user selects an account number in the from account # field")
    public void userSelectsAnAccountNumberInThe() {
        lf.SelectMenu(lf.fromAccount,0);
    }

    @And("user click on the Apply Now button")
    public void userClickOnTheButton() {
        lf.myClick(lf.applyButton);
    }

    @And("user confirms the following information:")
    public void userConfirmsTheFollowingInformation(DataTable datas) {
        List<List<String>> listTxtYazi = datas.asLists(String.class);

        for (int i = 0; i < listTxtYazi.size(); i++) {
            WebElement txtBoxWebElement = lf.getWebElement(listTxtYazi.get(i).get(0));
            if (listTxtYazi.get(i).get(0).equals("Account Number"))
                lf.verifyContainsText(txtBoxWebElement, accountNumber);
            else
                lf.verifyContainsText(txtBoxWebElement, listTxtYazi.get(i).get(1));
        }
    }

    @When("user Click on the link of the newly created credit account number")
    public void userClickOnTheLinkOfTheNewlyCreatedCreditAccountNumber() {
        accountNumber = lf.newAccountLink.getText();
        lf.myClick(lf.newAccountLink);
    }

    @And("user {string} confirms the message")
    public void userConfirmsTheMessage(String message) {
        lf.verifyContainsText(lf.transactionMessage,message);
    }

    @And("user confirms the following message: {string}")
    public void userConfirmsTheFollowingMessage(String message) {
        lf.verifyContainsText(lf.denyMessage,message);
    }
    }
}
