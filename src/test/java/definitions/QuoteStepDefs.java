package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;
import pages.QuoteForm;

import static support.TestContext.getDriver;

public class QuoteStepDefs{
    QuoteForm quotePage = new QuoteForm();

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        switch (page) {
            case "quote":
                quotePage.open();
                break;
            default:
                throw new RuntimeException("Not recognized page! Actual: " + page);
        }
    }

    @When("I fill out required fields oop")
    public void iFillOutRequiredFieldsOop() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Polina");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("pshever@yahoo");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Polina ");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Shev");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        quotePage.submit();
    }

    @Then("I verify required fields oop")
    public void iVerifyRequiredFieldsOop() {
        quotePage.verify();
    }
}
