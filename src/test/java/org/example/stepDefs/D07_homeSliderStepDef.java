package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D07_homeSliderStepDef {
    HomePage  HomePage = new HomePage(Hooks.driver);

    @When("user clicks on first slider")
    public void click_on_first_slider(){

        Hooks.driver.findElement(By.cssSelector("a[rel=\"0\"]")).click();
        HomePage.slider("1").click();
    }

    @Then("relative product for first slider is displayed")
    public void first_slide_displayed() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020","URL of First Slide");
    }

    @When("user clicks on second slider")
    public void click_on_second_slider() throws InterruptedException {
        HomePage = new HomePage(Hooks.driver);
//        Thread.sleep(2000);
        Hooks.driver.findElement(By.cssSelector("a[rel=\"1\"]")).click();
        HomePage.slider("2").click();
    }

    @Then("relative product for second slider is displayed")
    public void second_slide_displayed() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6","URL of Second Slide");
    }


}
