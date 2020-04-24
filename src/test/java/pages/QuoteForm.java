package pages;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteForm {
    private String url;

    public void open() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().get("https://skryabin.com/market/quote.html");
    }

    public void submit() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    public void verify() {
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(result);
        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();

        assertThat(result).contains("Polina");
        assertThat(result).contains("pshever@yahoo");
        assertThat(result).doesNotContain("welcome");

        String privacyPolicy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(privacyPolicy).isEqualTo("true");
        assertThat(password).isEqualTo("[entered]");

    }
}
