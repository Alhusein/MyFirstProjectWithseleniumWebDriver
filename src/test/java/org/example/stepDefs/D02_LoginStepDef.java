package org.example.stepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class D02_LoginStepDef {

    HomePage  HomePage = new HomePage(Hooks.driver);
    P02_login login = new P02_login(Hooks.driver);

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {

        HomePage.Navigate_to_LoginPage().click();
    }

    @When("user enter {string} and {string}")
    public void userEnterAnd(String email, String password) throws InterruptedException {
        login.LoginSteps(email, password);
        Thread.sleep(1000);
    }



    @And("user click on login button")
    public void click_button() {
        login.passwordE().sendKeys(Keys.ENTER);
    }

    @Then("user could login successfully and go to home page")
    public void login_successfully() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/","URL login");
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        soft.assertTrue(login.myAccount().isDisplayed(), "My Account");
        soft.assertAll();
    }

    @Then("user could not login successfully")
    public void unable_to_login() {
        SoftAssert soft = new SoftAssert();

        String actual = login.wrongMsg().getCssValue("color");
        String expected = "rgba(228, 67, 75, 1)";
        soft.assertEquals(actual, expected, "color");

        soft.assertAll();
    }

    }

