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


public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
//        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        //mouse over the element instead of clicking 2 different elements
        WebElement mailAndSnip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        getActions().moveToElement(mailAndSnip).perform();
//        new Actions(getDriver()).moveToElement(mailAndSnip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a")).click();
        getDriver().findElement(By.xpath("//a[contains(@class,'zip-code-address')]")).click();
//        Actions actions = new Actions(getDriver()); 
//        actions.moveToElement(mailAndSnip).perform();
//        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction!')]")).click();
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
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        //check if the container has that occurrence
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        getWait().until(ExpectedConditions.textToBePresentInElement(resultElement, zip));

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
            System.out.println(list.size());
//            assertThat(item.getText()).contains(zip);
            assertThat(itemText).contains(zip);

        }
//        getWait(10).until();

//        List<WebElement> list = getDriver().findElements(By.xpath("//*[@class='zipcode-result-address']"));
//        for (WebElement item : list) {
//            String itemText = item.getText();
//            System.out.println(itemText);
//            assertThat(itemText).contains(zip);
    }


    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
//        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        //mouse over instead of click
        WebElement mailAndSnip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        getActions().moveToElement(mailAndSnip).perform();
//        new Actions(getDriver()).moveToElement(mailAndSnip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-calc']//a")).click();

    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String postOption) throws InterruptedException {
        WebElement countryElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(countryElement).selectByVisibleText(country);
        getDriver().findElement(By.xpath("//label[contains(text(),'" + postOption + "')]")).click();
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

    @When("I go to Find a Location Page")
    public void iGoToFindALocationPage() {
        WebElement mailShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        getActions().moveToElement(mailShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-find']/a")).click();

    }


    @And("I filter by {string} Location Types, {string} Services, {string} Available Services")
    public void iFilterByLocationTypesServicesAvailableServices(String locationType, String service, String availableService) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//a[string()='" + locationType + "']")).click();
        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        getDriver().findElement(By.xpath("//li/a[text()='" + service + "']")).click();
        getDriver().findElement(By.xpath("//button[@id='available-service-select']")).click();
        getDriver().findElement(By.xpath("//a[string()='" + availableService + "']")).click();
    }

    @And("I fill in {string} street, {string} city, {string} state")
    public void iFillInStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();
        WebElement address = getDriver().findElement(By.xpath("//input[@id='addressLineOne']"));
//        WebDriverWait wait = new WebDriverWait(getDriver(),5);
//        getWait().until(ExpectedConditions.visibilityOf(address));
        //another option
//        getWait().until(ExpectedConditions.elementToBeClickable(address));
//        address.click();
        //1 option for debugging
//        Thread.sleep(1000);
        //2 option - try again
//        getWait().until(ExpectedConditions.elementToBeClickable(address));
        address.sendKeys(street);
//        if (!address.getAttribute("value").equals(street)){
//            address.clear();
//            address.sendKeys(street);

        //3 option - use while loop
        for (int i = 0; !address.getAttribute("value").equals(street) && i < 5; i++) {
            address.clear();
            address.sendKeys(street);
        }
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);
        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']"));
        new Select(stateElement).selectByValue(state);
        getDriver().findElement(By.xpath("//div[contains(@class,'goto')]/a")).click();
    }

    @Then("I print the phone number and validate it is {string}")
    public void iPrintThePhoneNumberAndValidateItIs(String phone) {
        getDriver().findElement(By.xpath("(//div[@id='resultBox']//div)[1]")).click();
        String resultPhone = getDriver().findElement(By.xpath("//p[@id='detailPhone']")).getText();
        assertThat(resultPhone).contains(phone);
    }

    @When("I click on {string}")
    public void iClickOn(String measurement) throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@id='menu']/ul/li/a[contains(text(),'" + measurement + "')]")).click();
        WebElement calFrom = getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        getWait().until(ExpectedConditions.elementToBeClickable(calFrom));

    }

    @And("I set {string} to {string}")
    public void iSetTo(String unitFrom, String unitTo) throws InterruptedException {
        //Select by actions
//        WebElement unit1Elem = getDriver().findElement(By.xpath("//select[@id='calFrom']//option[(text()='" + unitFrom +"')]"));
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(unit1Elem).click().perform();
//        WebElement calTo = getDriver().findElement(By.xpath("//select[@id='calTo']"));
//        getWait().until(ExpectedConditions.elementToBeClickable(calTo));
//        WebElement unit2Elem = getDriver().findElement(By.xpath("//select[@id='calTo']//option[text()='" + unitTo + "']"));
//        actions.moveToElement(unit2Elem).click().perform();
        //SelectByVisibleText
        WebElement calFromElement = getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        new Select(calFromElement).selectByVisibleText(unitFrom);
        WebElement calToElement = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        getWait().until(ExpectedConditions.elementToBeClickable(calToElement));
        new Select(calToElement).selectByVisibleText(unitTo);

    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String value, String passedResult) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);
        String resultValue = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        assertThat(resultValue).contains(passedResult);
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//a[contains(@href,'auto-loan')]")).click();
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
    }

    @And("I calculate")
    public void iCalculate() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@type='image']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        String result = getDriver().findElement(By.xpath("//tr//td[@valign='top'][2]")).getText();
        System.out.println(result);
        assertThat(result).contains(error);
//second option
//        List<WebElement> list = getDriver().findElements(By.xpath("//td[@valign='top']/div/font"));
//        List<String> errorMessages = new ArrayList<>();
//        for (WebElement item : list){
//            String errorMessage = item.getText();
//            errorMessages.add(errorMessage);
//        }
//        assertThat(errorMessages).contains(error);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String autoPrice, String loanTerm, String interestRate, String downPayment, String tradeInValue, String state, String percentTax, String fees) {
        getDriver().findElement(By.xpath("//input[@name='cloanamount']")).sendKeys(autoPrice);
        getDriver().findElement(By.xpath("//input[@name='cloanterm']")).sendKeys(loanTerm);
        getDriver().findElement(By.xpath("//input[@name='cinterestrate']")).sendKeys(interestRate);
        getDriver().findElement(By.xpath("//input[@name='cdownpayment']")).sendKeys(downPayment);
        getDriver().findElement(By.xpath("//input[@name='ctradeinvalue']")).sendKeys(tradeInValue);
        WebElement selectStateEl = getDriver().findElement(By.xpath("//select[@name='cstate']"));
        new Select(selectStateEl).selectByVisibleText(state);
        getDriver().findElement(By.xpath("//input[@name='csaletax']")).sendKeys(percentTax);
        getDriver().findElement(By.xpath("//input[@name='ctitlereg']")).sendKeys(fees);

    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String payments) {
        String resultValue = getDriver().findElement(By.xpath("//h2[contains(@class,'result')]")).getText();
        assertThat(resultValue.endsWith(payments)).isTrue();
    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + tab + "')]")).click();
        WebElement searchEl = getDriver().findElement(By.xpath("//input[contains(@class,'search')]"));
        getWait().until(ExpectedConditions.elementToBeClickable(searchEl));
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) throws InterruptedException {
        WebElement searchEl = getDriver().findElement(By.xpath("//input[contains(@class,'search')]"));
        searchEl.sendKeys(search);
        getDriver().findElement(By.xpath("//button[contains(@class,'search-button')]")).click();
        WebElement itemSearchEl = getDriver().findElement(By.xpath("//*[contains(@class,'ResultStencil')]"));
        getWait().until(ExpectedConditions.visibilityOf(itemSearchEl));
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String searchText) {
        //every single item verification
        List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(@class,'ResultStencil')]"));
        for (WebElement item : list) {
            System.out.println(item.getText());
            assertThat(item.getText()).doesNotContain(searchText);
        }
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String service, String tab) {
        WebElement tabEl = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + tab + "')]"));
        getActions().moveToElement(tabEl).perform();
        getDriver().findElement(By.xpath("//a[string()='" + service + "']")).click();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        WebElement addressEl = getDriver().findElement(By.xpath("//input[@id='address']"));
        getWait().until(ExpectedConditions.elementToBeClickable(addressEl));
        addressEl.sendKeys(address);
        addressEl.sendKeys(Keys.ENTER);
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String button) {
        WebElement toggle = getDriver().findElement(By.xpath("//a[@class='route-table-toggle']"));
        getWait().until(ExpectedConditions.elementToBeClickable(toggle));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", toggle);
    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@class='totalsArea']")).click();
        Thread.sleep(3000);
//        WebElement element = getDriver().findElement(By.xpath(xpath));
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].click();", element);
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebElement close = getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']"));
        getWait().until(ExpectedConditions.elementToBeClickable(close));
        close.click();
        WebElement modalWindow = getDriver().findElement(By.xpath("//div[@id='modal-box']"));
        getWait().until(ExpectedConditions.invisibilityOf(modalWindow));
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
//used Slava's code
        // initially we have not all elements
        // we need to scroll to the last element so more of them loaded (infinite scroll)
        // we get the number of total expected elements
        String totalCountString = getDriver().findElement(By.xpath("//a[contains(@class,'totalsArea')]")).getText();
        int totalCount = Integer.parseInt(totalCountString.replaceAll("\\D*", ""));

        // get locator of table cell list
        By costListSelector = By.xpath("//td[@idx='7']");
        // find current element list on the page
        List<WebElement> costList = getDriver().findElements(costListSelector);
        // get last element from the current costList
        int lastIndex = costList.size() - 1;
        WebElement lastElementInList = costList.get(lastIndex);
        // we scroll to the current last element

        getActions().moveToElement(lastElementInList).perform();
        // wait until total number of elements loaded
        getWait().until(ExpectedConditions.numberOfElementsToBe(costListSelector, totalCount));

        costList = getDriver().findElements(costListSelector);

        // summarize total
        double actualTotal = 0;
        for (WebElement cost : costList) {
            String costString = cost.getText().replace("$", "");
            double costTotal = Double.parseDouble(costString);
            actualTotal += costTotal;
        }
        System.out.println("Actual total: " + actualTotal);

        String expectedTotalString = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
        double expectedTotal = Double.parseDouble(expectedTotalString);
        System.out.println("Expected total: " + expectedTotal);

        // use approximate match
        assertThat(actualTotal).isCloseTo(expectedTotal, Percentage.withPercentage(1));

    }

    @And("I search on main page for {string}")
    public void iSearchOnMainPageFor(String searchText) {
        WebElement searchLookingGlass = getDriver().findElement(By.xpath("//li[contains(@class,'nav-search')]"));
        getActions().moveToElement(searchLookingGlass).perform();

        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        searchInput.sendKeys(searchText + Keys.ENTER);
//        searchInput.sendKeys(Keys.ENTER);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchValue) throws InterruptedException {
        //mouse over the search loop icon
        WebElement searchLoop = getDriver().findElement(By.xpath("//li[@class='nav-search menuheader']"));
        getActions().moveToElement(searchLoop).perform();
        String upperSearchValue = searchValue.toUpperCase();
        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(text(),'" + upperSearchValue + "')]")).click();
        System.out.println(getDriver().getTitle());
        // explicit wait

    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        By locator = By.xpath("//div[@class='white-spinner-container']");
//        WebElement filter = getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']"));
        getWait(60).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][contains(text(),'" + filter + "')]")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String count) throws InterruptedException {
        By locator = By.xpath("//div[@class='white-spinner-container']");
//        WebElement filter = getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']"));
        getWait(60).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        List<WebElement> list = getDriver().findElements(By.xpath("//li[contains(@class,'result-item')]"));
        System.out.println("Number of Elements: " + list.size());
        int numberElements = list.size();
        int countInt = Integer.valueOf(count);
        for (WebElement item : list) {
            System.out.println(item.getText());
        }

        assertThat(numberElements).isEqualTo(countInt);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String sendOption) {
        getDriver().findElement(By.xpath("//span[text()='" + sendOption + "']")).click();
    }


    @And("I click {string} button")
    public void iClickButton(String button) throws InterruptedException {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')]")).click();

    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String firstWindow = getDriver().getWindowHandle();
        for (String window : getDriver().getWindowHandles()){
            getDriver().switchTo().window(window);
        }
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-submit']")));
        WebElement signInButton = getDriver().findElement(By.xpath("//button[@id='btn-submit']"));
        assertThat(signInButton.isDisplayed()).isTrue();
        getDriver().switchTo().window(firstWindow);

    }
}



