package stepDefinitions;

import FunctionLibrary.CommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class checkoutSteps extends CommonFunctions {


    @When("I click checkout button")
    public void iClickCheckoutButton() {
        clickElement(driver, By.xpath("//button [@name='checkout']"));
    }

    @Then("checkout details page should be displayed.")
    public void checkoutDetailsPageDisplayed() {
        asserTrue(driver, By.className("title"));
    }

    @And("I click on Continue button")
    public void clickContinueButton() {

        clickElement(driver, By.id("continue"));
    }

    @Then("the error {string} should be displayed")
    public void errorShouldBeDisplayed(String error) {
        //System.out.println(driver.findElement(By.xpath("//h3[@data-test='error' and text() ='Error: First Name is required']")).getText());
        assertequals(error, driver, By.xpath("//h3[@data-test='error' and text() ='" + error + "']"));
    }

    @And("click on error button")
    public void clickOnErrorButton() {
        clickElement(driver, By.className("error-button"));
    }


    @When("I enter first name as {string}")
    public void firstName(String name) {
        sendKey(driver, By.id("first-name"), name);

    }

    @When("I enter last name as {string}")
    public void lastName(String name) {
        sendKey(driver, By.id("last-name"), name);

    }

    @When("I enter postalCode {string}")
    public void postCode(String postalCode) {
        sendKey(driver, By.xpath("//input[@data-test='postalCode']"), postalCode);
    }

    @Then("I should redirect to checkout overview page")
    public void checkoutOverview() {
        asserTrue(driver, By.className("title"));
    }

    @When("I click finish button")
    public void finishButton() {
        clickElement(driver, By.id("finish"));
    }

    @Then("my order should go through")
    public void orderPassed() {
        asserTrue(driver, By.className("title"));
    }

    @And("I click backhome button")
    public void backhomeButton() {
        clickElement(driver, By.id("back-to-products"));
    }

    @Then("I should be direct to home page")
    public void directToHomePage() {
        asserTrue(driver, By.className("title"));
    }


}
