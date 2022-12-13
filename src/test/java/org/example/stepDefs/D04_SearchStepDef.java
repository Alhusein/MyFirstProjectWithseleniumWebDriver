package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.P04_Search;
import org.testng.asserts.SoftAssert;

public class D04_SearchStepDef {
    HomePage HomePage  = new HomePage(Hooks.driver);
    P04_Search search = new P04_Search(Hooks.driver);

    @Given("user clicks on search field")
    public void search_field() {

        HomePage.search().click();
    }


    @When("user search for product name like {string}")
    public void userSearchForProductNameLike(String search) {
        HomePage.search().sendKeys(search);
    }

    @And("user click on search Button")
    public void search_Button() {

        HomePage.search_Button().click();
    }

    @Then("user could search successfully")
    public void search_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=Nokia"), "search URL");

    }

    @Then("user could search successfully with SKU code")
    public void successfully_with_SKU_code() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=AP_MBP_13"), "URL after search");

    }

    @Then("user could not search for the product")
    public void unable_to_search() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(search.noProducts().isDisplayed(), "No products");
    }
}