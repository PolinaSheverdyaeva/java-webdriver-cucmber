package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        switch (page.toLowerCase()) {
            case "ecosia":
                getDriver().get("https://www.ecosia.org/");
                break;
            case "calculator":
                getDriver().get("http://www.calculator.net/");
                break;
            case "converter":
                getDriver().get("https://www.unitconverters.net/");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            case "ups":
                getDriver().get("https://www.ups.com/us/en/Home.page");
                break;
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://google.com");
                break;
            case "yahoo":
                getDriver().get("https://au.yahoo.com");
                break;
            case "australia post":
                getDriver().get("https://auspost.com.au/");
                break;
            default:
//                System.out.println("Not recohnised page" + page);
                throw new RuntimeException("Not recognized page! Actual: " + page);
        }


    }

    //getDriver() exercises
    @And("I print details in console")
    public void iPrintDetailsInConsole() {
//        String url = getDriver().getCurrentUrl();
//        System.out.println("url: " + url);
//        String title = getDriver().getTitle();
//        System.out.println("page title: " + title);
//        final String windowHandle = getDriver().getWindowHandle();
//        System.out.println("window handle: " + windowHandle);
//        final Set<String> windowHandles = getDriver().getWindowHandles();
//        System.out.println("window handles: " + windowHandles);
//        final String pageSource = getDriver().getPageSource();
//        System.out.println("page source: " + pageSource);


        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getWindowHandles());
        System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
//        WebDriver browser = getDriver();
//        WebElement element = browser.findElement(By.xpath("//input[@name='username']"));
//        String myXpath = "//input[@name='email']";
//        By mySelector = By.xpath(myXpath);
//        element.sendKeys("Polina");
//        getDriver().findElement(mySelector).sendKeys("pshever@yahoo");
//        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password");
//        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password");
//        getDriver().findElement(By.xpath("//input[@id='name']")).click();
//        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Polina ");
//        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Shev");
//        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
//        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
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

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }


    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String dimension) {
        if (dimension.equalsIgnoreCase("phone")) {
            getDriver().manage().window().setSize(new Dimension(400, 768));
        } else if (dimension.equalsIgnoreCase("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
        } else {
            throw new RuntimeException("Not recognized dimension! Actual: " + dimension);

//
//        switch(dimension.toLowerCase()){
//            case "phone":
//                getDriver().manage().window().setSize(new Dimension(400,768));
//            case "desktop":
//                getDriver().manage().window().setSize(new Dimension(1024,768));
//            default:
////                System.out.println("Not recohnised dimension" + dimension);
//                throw new RuntimeException("Not recognized dimension! Actual: " + dimension);
        }

    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("psyahoo");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.ENTER);
//        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("pyahoo");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.ENTER);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("ps@yahoo");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.ENTER);


    }



    @When("I fill out optional fields")
    public void iFillOutOptionalFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("12345678");
//        date of Birth
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@*='selectMonth']/option[1]")).click();
        getDriver().findElement(By.xpath("//select[@*='selectYear']/option[@value='1982']")).click();
        getDriver().findElement(By.xpath("//td[@*='selectDay']/a[text()='28']")).click();
//        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
//        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Russia']")).click();
        WebElement countrySelect = getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']"));
        new Select(countrySelect).selectByValue("China");

        Thread.sleep(1000);
        new Select(countrySelect).selectByValue("Russia");
        getDriver().findElement(By.xpath("//*[@name='gender'][@value='female']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']/../span")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("1 Nowhere St, Nowherengton");
        getDriver().findElement(By.xpath("//select[@name='carMake']//option[@value='Other']")).click();
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("Polina");
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("87654321");
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().findElement(By.xpath("//input[@id='attachment']")).sendKeys("C:/Users/polina/Documents/Test Documentation/Decomposition.docx");

    }

    @Then("I verify optional fields")
    public void iVerifyOptionalFields() {
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        String privacy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        String allowedToContact = getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText();
        String carMake = getDriver().findElement(By.xpath("//b[@name='carMake']")).getText();


        assertThat(result).contains("12345678");
        assertThat(result).contains("01/28/1982");
        assertThat(result).contains("Russia");
        assertThat(result).contains("1 Nowhere St, Nowherengton");
        assertThat(carMake).isEqualTo("Other");
        assertThat(getDriver().findElement(By.xpath("//b[@name='contactPersonName']")).getText().contains("Polina"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='contactPersonPhone']")).getText()).isEqualTo("87654321");
        assertThat(privacy).isEqualTo("true");
        assertThat(password).isEqualTo("[entered]");
        assertThat(allowedToContact).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText().contains("accepted"));

    }

    @Then("I verify required fields")
    public void iVerifyRequiredFields(){
//        assertThat(getDriver().getTitle()).isEqualToIgnoringCase("Get a Quote");
//        assertThat(getDriver().findElement(By.xpath("//input[@name='username']")).getAttribute("value")).isEqualTo("Polina");
//        assertThat(getDriver().findElement(By.xpath("//input[@name='email']")).getAttribute("value")).contains("ps@yahoo");
//        assertThat(getDriver().findElement(By.xpath("//input[@id='password']")).getAttribute("value")).isEqualTo("password");
//        assertThat(getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).isDisplayed()).isTrue();
//        assertThat(getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).getAttribute("value")).isEqualTo("password");
//        assertThat(getDriver().findElement(By.xpath("//input[@id='name']")).getAttribute("value")).isEqualTo("Polina  Shev");
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(result);


//
//        Submitted Application
//        Username Polina
//        Email pshever@yahoo
//                Password [entered]
//        First Name Polina
//        Last Name Shev
//        Name Polina Shev
//        Agreed To Privacy Policy true
//        Phone 12345678
//        Date Of Birth 01/28/1982
//        Country Of Origin Russia
//        Gender female
//        Allowed To Contact true
//        Address 1 Nowhere St, Nowherengton
//        Car Make Other
//        Contact Person Name Polina
//        Contact Person Phone 87654321
//        Location Los Altos, CA 94022
//        Current Date 04/02/2020
//        Current Time 6:55 am Australian Eastern Daylight Time
//        Third Party Agreement accepted
//        Attachment Name Decomposition.docx
//
//                Return

        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();

        assertThat(result).contains("Polina");
        assertThat(result).contains("pshever@yahoo");
        assertThat(result).doesNotContain("welcome");


        String privacyPolicy = getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText();
        assertThat(privacyPolicy).isEqualTo("accepted");
        assertThat(password).isEqualTo("[entered]");




//        if (!result.contains("otherUsername")) {
//            throw new RuntimeException("Doesn't contain Polina");
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
            Thread.sleep(4000);
        LogEntries logs = getDriver().manage().logs().get("browser");
//        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);

        System.out.println(">>>>>>>>Browser logs. Begin:");
       for (LogEntry log : logs){
           System.out.println(log);
       }
        System.out.println(">>>>>>>>>Browser logs. End");
    }

    @And("I fill multi-select")
    public void iFillMultiSelect() {
        WebElement ford = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Ford']"));
        WebElement bmw = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='BMW'] "));

//        Actions actions = new Actions(getDriver());

//        actions.moveToElement(ford).click().pause(1000).keyDown(Keys.CONTROL).moveToElement(bmw).click().perform();

//        1 option
        new Actions(getDriver())
                .click(ford)
                .keyDown(Keys.CONTROL)
                .click(bmw)
                .perform();

        //2 option
//        WebElement carsElement = getDriver().findElement(By.xpath("//select[@name='carMake']"));
//        Select carsSelect = new Select(carsElement);
//        carsSelect.selectByValue("Ford");
////        carsSelect.deselectByValue("Ford");
//        carsSelect.selectByValue("BMW");
    }

    @And("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']"));
        if (action.equals("accept")){
            getDriver().switchTo().alert().accept();
        } else {
        getDriver().switchTo().alert().dismiss();
    }
}

    @And("fill out additional info with name {string} and phone{string}")
    public void fillOutAdditionalInfoWithNameAndPhone(String name, String phone) throws InterruptedException {
        getDriver().switchTo().frame("additionalInfo");

        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(phone);
        getDriver().switchTo().defaultContent();

        Thread.sleep(5000);
    }

    @And("I verify {string} present on related docs page")
    public void iVerifyPresentOnRelatedDocsPage(String docName) {
        String originalWindow = getDriver().getWindowHandle();
        getDriver().findElement(By.xpath("//button[contains(@onclick,'new')]")).click();

        // switch to last window handle
        for (String handle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(handle);
        }
        String docs = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(docs).contains(docName);
        assertThat(getDriver().getTitle()).isEqualTo("Documents Page");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);
    }

    @And("I fill out search engine field with {string} and search")
    public void iFillOutSearchEngineFieldWithAndSearch(String searchValue) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys(searchValue);
        WebElement button = getDriver().findElement(By.xpath("//button[(@type='submit')]"));
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        getExecutor().executeScript("arguments[0].click();", button);
        System.out.println();
    }
}


