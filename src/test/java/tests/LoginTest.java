package tests;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {
    WebDriver driver;

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        driver = Hooks.driver;
    }

    @When("user logs in with {string} and {string}")
    public void Login(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        usernameInput.clear();
        usernameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();
    }

    @Then("user should see the {string} page")
    public void Product(String productTitle) {
        WebElement title = driver.findElement(By.className("title"));
        Assert.assertEquals(title.getText(),productTitle);
    }


    @Then("user should see the message {string}")
    public void ErrorMessage(String error_message) {
        WebElement message = driver.findElement(By.xpath("//div[contains(@class,'error-message-container')]"));
        Assert.assertEquals(error_message,message.getText());

    }
}
