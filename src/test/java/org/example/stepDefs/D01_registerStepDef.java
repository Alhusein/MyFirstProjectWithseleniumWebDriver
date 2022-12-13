package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;

import org.example.pages.P01_Register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


import java.sql.Driver;

public class D01_registerStepDef {
    HomePage homepage = new HomePage(Hooks.driver);
    P01_Register register = new P01_Register (Hooks.driver);

    @Given("user navigate to register page")
    public void register_page() {

        homepage.Navigate_to_RegisterPage().click();
    }

    @And("user select gender type")
    public void Gender(){
        register.maleGender().click();
    }

   @When("user enter valid data")
    public void user_enter_first_name(){
        register.firstName().sendKeys("Alhusein");

        register.lastName().sendKeys("Ibrahim");

        Select select = new Select(register.birthDay());
        select.selectByIndex(20);

        select = new Select(register.birthMonth());
        select.selectByVisibleText("February");

        select = new Select(register.birthYear());
        select.selectByValue("1995");


        register.email().sendKeys("aalhussein.ibrahim@gmail.com");

        register.companyName().sendKeys("Julfar");

        register.password().sendKeys("kkll2022");
        register.confirmPassword().sendKeys("kkll2022");
    }

    @And("user click on register button")
    public void register_button()
    {
        register.registerB().click();
    }

    @Then("success message is displayed")
    public void register_successfully() {

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successfulMsg().isDisplayed(), "Success Message");

        String actual = register.successfulMsg().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "color is correct");

        soft.assertAll();
    }












}
