package tests;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartTest {

    WebDriver driver;

    @Given("user is logged in")
    public void user_is_logged_in() {
        driver = Hooks.driver;
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        usernameInput.clear();
        usernameInput.sendKeys("standard_user");

        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        submitButton.click();
    }
    @Given("user is on the products page")
    public void user_is_on_the_products_page() {
        WebElement title = driver.findElement(By.className("title"));
        Assert.assertEquals("Products",title.getText());
    }
    @When("user adds {string} to the cart")
    public void user_adds_to_the_cart(String productItem) {
        WebElement product = driver.findElement(By.xpath("//div[text()='" + productItem + "']/ancestor::div[@class='inventory_item']//button"));
        product.click();


    }
    @Then("cart icon should show {string}")
    public void cartIcon(String num) {
        WebElement cartNum = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
        Assert.assertEquals(cartNum.getText(),num);


    }
    @Then("the cart should contain {string}")
    public void the_cart_should_contain(String cartItem) {
        WebElement clickCart = driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']"));
        clickCart.click();;
        WebElement cart = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
        Assert.assertEquals(cart.getText(),cartItem);
    }


    @Given("user has {string} in the cart")
    public void userHasInTheCart(String IncartItem) {
        WebElement product = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertEquals(product.getText(),IncartItem);
    }

    @When("user removes {string} from the cart")
    public void RemovesFromTheCart(String removeItem) {
        WebElement removeProduct = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeProduct.click();

    }

    @And("the cart should not contain {string}")
    public void theCartShouldNotContain(String empty) {

        WebElement cartEmpty = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
        Assert.assertEquals(cartEmpty.getText(),empty);
    }

}
