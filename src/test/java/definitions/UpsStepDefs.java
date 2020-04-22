package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.assertj.core.data.Percentage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static support.TestContext.*;


import static org.assertj.core.api.Assertions.assertThat;


public class UpsStepDefs {

    @When("I open {string} menu")
    public void iOpenMenu(String menu) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//li[@class='ups-navMenu ups-menu']/a[contains(text(), '"+menu+"')]")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='ups-med_show'][contains(text(),'"+menu+"')]/..")));

    }

    @And("I go to {string}")
    public void iGoToMenuItem(String menuitem) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//ul/li/a[contains(text(),'"+menuitem+"')]")).click();

    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {

        //close cookie consent floating window if present
        WebElement divEl = getDriver().findElement(By.xpath("//div[@id='__tealiumImplicitmodal']"));
        if (divEl.isDisplayed()) {
            getDriver().findElement(By.xpath("//button[@class='close_btn_thick']")).click();
        }

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='originname']")));

        WebElement countryEl = getDriver().findElement(By.xpath("//select[@id='origincountry']"));
        new Select(countryEl).selectByVisibleText("United States");

        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("Administrator");
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys("4970 El Camino Real");
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("94022");
//        getDriver().findElement(By.xpath("//input[@id='origincity']")).sendKeys("Los Altos");
//
//        WebElement stateEl = getDriver().findElement(By.xpath("//select[@id='originstate']"));
//        new Select(stateEl).selectByVisibleText("California");
        getWait().until(ExpectedConditions.attributeContains(By.xpath("//input[@id='originpostal']"), "class", "ng-valid"));

        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"), "LOS ALTOS"));

        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("mail@example.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("1234567890" + Keys.TAB);

        getWait().until(ExpectedConditions.attributeContains(By.xpath("//input[@id='originphone']"), "class", "ng-valid"));


    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {

        WebElement buttonEl = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        //scroll to make button visible so it's not obscured by anything
        getActions().moveToElement(buttonEl).perform();

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", buttonEl);
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='originnbsAgentSummaryName']")));

        String name = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryName']")).getText();
        assertThat(name).isEqualTo("Administrator");
        String addressLine1 = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryAddressLine1']")).getText();
        assertThat(addressLine1).isEqualTo("4970 El Camino Real");
        String city = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryCity']")).getText();
        assertThat(city).isEqualTo("LOS ALTOS");
        String state = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryState']")).getText();
        assertThat(state).isEqualTo("CA");
        String zip = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPostalCode']")).getText();
        assertThat(zip).isEqualTo("94022");
        String country = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryCountryCode']")).getText();
        assertThat(country).isEqualTo("US");
        String email = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryEmail']")).getText();
        assertThat(email).isEqualTo("mail@example.com");
        String phone = getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPhone']")).getText();
        assertThat(phone).isEqualTo("1234567890");
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() throws InterruptedException {

        WebElement buttonCancel = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']"));
        getActions().moveToElement(buttonCancel).perform();

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", buttonCancel);


//        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")));
//        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")).click();

        //wait until confirmation dialog and click Yes
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='modal-title'][contains(text(), 'Are you sure')]")));
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }


    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='originname']")));

        WebElement countryEl = getDriver().findElement(By.xpath("//select[@id='origincountry']"));
        String country = new Select(countryEl).getFirstSelectedOption().getText();
        assertThat(country).isEqualTo("United States"); //US is the default value
        String name = getDriver().findElement(By.xpath("//input[@id='originname']")).getAttribute("value");
        assertThat(name).isEqualTo("");
        String addressline1 = getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getAttribute("value");
        assertThat(addressline1).isEqualTo("");
        String originpostal = getDriver().findElement(By.xpath("//input[@id='originpostal']")).getAttribute("value");
        assertThat(originpostal).isEqualTo("");
        String origincity = getDriver().findElement(By.xpath("//input[@id='origincity']")).getAttribute("value");
        assertThat(origincity).isEqualTo("");
        String originemail = getDriver().findElement(By.xpath("//input[@id='originemail']")).getAttribute("value");
        assertThat(originemail).isEqualTo("");
        String originphone = getDriver().findElement(By.xpath("//input[@id='originphone']")).getAttribute("value");
        assertThat(originphone).isEqualTo("");
        WebElement stateEl = getDriver().findElement(By.xpath("//select[@id='originstate']"));
        String state = new Select(stateEl).getFirstSelectedOption().getText();
        assertThat(state).isEqualTo("Select One");

    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='destinationname']")));

        WebElement countryEl = getDriver().findElement(By.xpath("//select[@id='destinationcountry']"));
        new Select(countryEl).selectByVisibleText("United States");

        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys("John Doe");
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys("870 7th Ave");
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys("10019");

        getWait().until(ExpectedConditions.attributeContains(By.xpath("//input[@id='destinationpostal']"), "class", "ng-valid"));

        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='destinationcity']"), "NEW YORK"));

        String city = getDriver().findElement(By.xpath("//input[@id='destinationcity']")).getAttribute("value");
        assertThat(city).isEqualTo("NEW YORK");

        WebElement stateEl = getDriver().findElement(By.xpath("//select[@id='destinationstate']"));
        String state = new Select(stateEl).getFirstSelectedOption().getText();
        assertThat(state).isEqualTo("New York");

    }


    @And("I set packaging type")
    public void iSetPackagingType() {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']")));

        WebElement pkgEl = getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']"));
        new Select(pkgEl).selectByVisibleText("UPS Express Box - Small");

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nbsPackagePackageWeightField0']")));

        //wait for packaging type text and graphics to appear
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@class='ng-star-inserted']"), "The UPS Express Box"));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='ups-package_image ng-star-inserted']")));


        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("1"+Keys.TAB);
        getWait().until(ExpectedConditions.attributeContains(By.xpath("//input[@id='nbsPackagePackageWeightField0']"), "class", "ng-valid"));

    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='cust-input-Cheapest']")));

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Cheapest']")));


        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//service[@id='nbsShipmentServicesService']")));

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//service[@id='nbsShipmentServicesService']//section[@class='ups-section']")));

//        WebElement el = getDriver().findElement(By.xpath("//div[@class='shipping-option-label']"));
//        getActions().moveToElement(el).perform();
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='shipping-option-label']/p"), "Select a shipping service option"));

        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@id='cust-input-Cheapest']")).click();
    }

    @And("I set Saturday Delivery type")
    public void iSetSaturdayDeliveryType() {

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='nbsSaturdayDeliveryOptionBaseOptionSwitch']")));

        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("test");

        //getDriver().findElement(By.xpath("//input[@id='nbsSaturdayDeliveryOptionBaseOptionSwitch']")).click();

        getDriver().findElement(By.xpath("//saturday-delivery-option[@class='ng-star-inserted']//span[@class='ups-lever_switch_bg']")).click();
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {

        String total1 = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();

        //wait until spinner stops
        getWait().until(ExpectedConditions.attributeContains(By.xpath("//spinner[@class='ng-tns-c2-1']//img"), "style", "opacity: 0"));

        String total2 = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();

        assertThat(total1).isNotEqualTo(total2);
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        getWait(60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='nbsSpinnerLoadingAltText']")));
        String total = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();
        assertThat(total).isNotEmpty();
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() throws InterruptedException {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Other Ways to Pay')]")));

        getDriver().findElement(By.xpath("//span[contains(text(),'Other Ways to Pay')]")).click();

        getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class='ups-radio-custom-label ng-star-inserted']"), "PayPal"));

        getDriver().findElement(By.xpath("//label[@class='ups-radio-custom-label ng-star-inserted']")).click();

        Thread.sleep(5000);
    }

    @And("I submit the payment form")
    public void iSubmitThePaymentForm() {

        WebElement buttonEl = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']"));
        //scroll to make button visible so it's not obscured by anything
        getActions().moveToElement(buttonEl).perform();

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", buttonEl);
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        String resultShipFrom = getDriver().findElement(By.xpath("//origin-return-drawer[@class='ng-star-inserted']//section[@class='ups-section col-md-6']")).getText();
        System.out.println(resultShipFrom);
        String resultShipTo = getDriver().findElement(By.xpath("//destination[@id='nbsSpaDestination']//section[@class='ups-section col-md-6']")).getText();
        System.out.println(resultShipTo);
        assertThat(resultShipFrom).contains("Administrator");
        assertThat(resultShipFrom).contains("4970 El Camino Real, LOS ALTOS, CA 94022");
        assertThat(resultShipFrom).contains("mail@example.com, 1234567890");

        assertThat(resultShipTo).contains("John Doe");
        assertThat(resultShipTo).contains("870 7th Ave, NEW YORK, NY 10019");

    }
}



