package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.example.pages.P08_Wishlist;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    HomePage homepage;
    P08_Wishlist wish;
    int num;

    @Given("user add item to wishlist")
    public void user_add_item_to_wishlist() {
        homepage = new HomePage(Hooks.driver);
        wish = new P08_Wishlist(Hooks.driver);
        homepage.add_button().get(2).click();
    }

    @Then("wishlist success operation massage is visible")
    public void success_notification() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(homepage.wishSuccessMsg().isDisplayed(), "Success Message");

        String actual = homepage.wishSuccessMsg().getCssValue("background-color");
        String expected = "rgba(75, 176, 122, 1)";
        soft.assertEquals(actual, expected, "Message color");
        soft.assertAll();
    }

    @And("user can get the number of wishlist items added")
    public void items_increased() {
        String text = homepage.wishList().getText();
        text = text.replaceAll("[^0-9]", "");
        num = Integer.parseInt(text);
    }

    @Then("the number of wishlist increased")
    public void number_of_items_of_wishlist() throws InterruptedException {
        Assert.assertTrue(num > 0, "count of wishlist items");
    }

    @And("user can go to wishlist page")
    public void user_go_to_wishlist() throws InterruptedException {
        homepage.closeB().click();
        Thread.sleep(500);
        homepage.wishList().click();
    }

    @Then("the number of items greater than zero in wishlist page")
    public void wishlist_Page_Assertion() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/wishlist"), "wishlist URL");
        int size = wish.wishListItems();
        soft.assertTrue(size > 0,"wishlist items");
        soft.assertAll();
    }
}
