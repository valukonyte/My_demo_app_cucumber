package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.StartStopServer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Steps extends StartStopServer {

    @Before("@setUp")
    public void setup(){
        runServer();
    }

    @After("@setUp")
    public void stop(){
        tearDown();
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String page) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + page + "\")")).isDisplayed();
    }

    @When("User clicks {string} button")
    public void user_click_button(String button) {
        driver.findElement(AppiumBy.accessibilityId(button)).click();
    }

    @Then("First product title is {string}")
    public void first_product_title_is(String title) {
        String element = driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item text\")")).get(0).getText();
        assertEquals(element, title);
    }


}
