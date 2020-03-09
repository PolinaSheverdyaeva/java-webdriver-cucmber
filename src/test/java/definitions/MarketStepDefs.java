package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import java.util.Set;

import static support.TestContext.getDriver;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch(page.toLowerCase()){
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://google.com");
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
        getDriver().findElement(By.xpath("//input[@name='email']")).click();
    }
}
