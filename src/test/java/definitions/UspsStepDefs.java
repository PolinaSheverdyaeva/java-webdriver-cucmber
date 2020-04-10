package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static support.TestContext.*;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction!')]")).click();
        getDriver().findElement(By.xpath("//a[contains(@class,'zip-code-address')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(stateElement).selectByValue(state);

//        Select stateSelect = new Select(stateElement);
//        stateElement.selectByValue(state);

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();

    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip ) throws InterruptedException {
        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        //check if the container has that occurrence
        WebDriverWait wait = new WebDriverWait(getDriver(),  5);
        wait.until(ExpectedConditions.textToBePresentInElement(resultElement, zip));

//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.textToBePresentInElement(resultElement, zip));

//        getWait().until(ExpectedConditions.textToBePresentInElement(resultElement, zip));
//        more examples:
//        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
//        wait.until(ExpectedConditions.elementToBeSelected(actual option to be selected, after zip code is typed));

//        getDriver().findElements(By.xpath("//*[@class='zipcode-result-address']")).get(0).getText();

            //every single item verification
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@class='zipcode-result-address']"));
        for (WebElement item : list) {
            String itemText = item.getText();
            System.out.println(item.getText());
//            assertThat(item.getText()).contains(zip);
            assertThat(itemText).contains(zip);

        }

//        List<WebElement> list = getDriver().findElements(By.xpath("//*[@class='zipcode-result-address']"));
//        for (WebElement item : list) {
//            String itemText = item.getText();
//            System.out.println(itemText);
//            assertThat(itemText).contains(zip);
        }

        //Homework 8
    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage()  {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'calculate')]")).click();

    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String postOption) throws InterruptedException {
        WebElement countryElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(countryElement).selectByVisibleText(country);
        getDriver().findElement(By.xpath("//input[@id='option_1']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
        getDriver().findElement(By.xpath("//input[contains(@class,'default')]")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) {

        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).isEqualTo(price);

    }
}



