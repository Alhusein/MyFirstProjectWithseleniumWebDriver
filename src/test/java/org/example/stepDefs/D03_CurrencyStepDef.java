package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D03_CurrencyStepDef {
    HomePage HomePage = new HomePage(Hooks.driver);

    @When("user select “euro” from currency dropdown list")
    public void userSelectEuroFromCurrencyDropdownList() {

        HomePage.currency_symbol().click();
        HomePage.currencyEuro().click();
    }

    @Then("All the products change to euro symbol")
    public void AllTheProductschangeToEuroSymbol() {
        int count = Hooks.driver.findElements(By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")).size();
        for (int x = 0; x < count; x++) {
            String text = HomePage.productPrices().getText();
            Assert.assertTrue(text.contains("€"));
        }
    }

}