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

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
    }

    @And("user is on the products page")
    public void user_is_on_the_products_page() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Products", title);
    }

    @When("user adds {string} to the cart")
    public void user_adds_item_to_the_cart(String itemName) {
        driver.findElement(
                By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button")
        ).click();
    }

    @Then("cart icon should show {string}")
    public void cart_icon_should_show(String count) {
        String badgeText = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(count, badgeText);
    }

    @And("the cart should contain {string}")
    public void the_cart_should_contain(String itemName) {
        driver.findElement(By.className("shopping_cart_link")).click();

        Assert.assertFalse(
                driver.findElements(
                        By.xpath("//div[@class='cart_item']//div[text()='" + itemName + "']")
                ).isEmpty()
        );
    }

    @Given("the cart contains {string}")
    public void the_cart_contains(String itemName) {
        user_adds_item_to_the_cart(itemName);
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("user removes {string} from the cart")
    public void user_removes_item_from_the_cart(String itemName) {
        driver.findElement(
                By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='cart_item']//button")
        ).click();
    }

    @Then("cart icon should be empty")
    public void cart_icon_should_be_empty() {
        Assert.assertTrue(
                driver.findElements(By.className("shopping_cart_badge")).isEmpty()
        );
    }

    @And("the cart should not contain {string}")
    public void the_cart_should_not_contain(String itemName) {
        Assert.assertTrue(
                driver.findElements(
                        By.xpath("//div[@class='cart_item']//div[text()='" + itemName + "']")
                ).isEmpty()
        );
    }

    @When("user clicks on the cart logo user lands on the carts page")
    public void userClicksOnTheCartLogoUserLandsOnTheCartsPage() {
        WebElement clickCrtBtn = driver.findElement(By.className("shopping_cart_link"));
        clickCrtBtn.click();

    }

    @Then("user validates the {string} URL")
    public void userValidatesTheURL(String url) {
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,url);


    }

    @And("user validates the {string} page title")
    public void userValidatesThePageTitle(String CartTitle) {
        WebElement getCartTitle = driver.findElement(By.xpath("//span[text()='Your Cart']"));
        Assert.assertEquals(getCartTitle.getText(),CartTitle);
    }
}
