package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.P05_hoverCategories;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    HomePage HomePage = new HomePage(Hooks.driver);
    P05_hoverCategories category = new P05_hoverCategories(Hooks.driver);
    String subCategoryName;

    @When("user select category and subcategory")
    public void select_category() throws InterruptedException {


        Actions action = new Actions(Hooks.driver);
        action.moveToElement(HomePage.computers()).perform();
        action.moveToElement(HomePage.computers()).perform();

        subCategoryName = HomePage.desktops().getText().toLowerCase();

        Thread.sleep(1000);
    }

    @And("user click on subcategory")
    public void user_clicks_subcategory(){
        HomePage.desktops().click();
    }

    @Then("user find relative product page")
    public void product_found(){
        Assert.assertEquals(category.categoryList().getText().toLowerCase(),subCategoryName,"subcategory");
    }


}

