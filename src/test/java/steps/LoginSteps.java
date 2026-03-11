package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("user opens the login page")
    public void userOpensTheLoginPage() {
        loginPage = new LoginPage(Hooks.getDriver());
        loginPage.open();
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLogin();
    }

    @Then("successful login message should be displayed")
    public void successfulLoginMessageShouldBeDisplayed() {
        String actual = loginPage.getSuccessMessage();
        Assertions.assertEquals("Logged In Successfully", actual, "Login success message did not match");
    }
}
