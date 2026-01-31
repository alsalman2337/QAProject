package tests;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageTest {
    WebDriver driver;

    @Given("user lands on correct webpage")
    public void user_lands_on_correct_webpage() {
        driver = Hooks.driver;
    }

    @Then("close the browser")
    public void closeBrowser(){

        driver.close();
    }


    @Then("user validates the title {string}")
    public void Title(String title) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,title);

    }

    @Then("user validates the placeholders")
    public void Placeholder() {
       String [] ids = {"user-name","password"};
       String [] placeholder = {"Username","Password"};
        for (int i =0; i< ids.length;i++) {
            WebElement ph = driver.findElement(By.id(ids[i]));
            String actualph = ph.getAttribute("placeholder");
            Assert.assertEquals(placeholder[i],actualph);
        }

    }


    @Then("user validates the {string} button")
    public void Button(String button) {
        WebElement btn = driver.findElement(By.id("login-button"));
        Assert.assertEquals(btn.getAttribute("value"),button);
    }



}
