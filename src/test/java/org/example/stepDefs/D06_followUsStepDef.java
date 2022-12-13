package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D06_followUsStepDef {
    HomePage  HomePage = new HomePage(Hooks.driver);
    @Given("user opens facebook Pop")
    public void user_opens_facebook() {

        HomePage.facebook().click();
    }

    @Given("user opens twitter link")
    public void user_opens_twitter() {
        HomePage = new HomePage(Hooks.driver);
        HomePage.twitter().click();
    }


    @Given("user opens youtube link")
    public void user_opens_youtube() {
        HomePage = new HomePage(Hooks.driver);
        HomePage.youtube().click();
    }

    @Given("user opens rss link")
    public void user_opens_rss() {
        HomePage = new HomePage(Hooks.driver);
        HomePage.rss().click();
    }



    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String linkType) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

        switch (linkType) {

            case "facebook-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce","facebook link");
                break;

            case "twitter-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce","twitter link");
                break;

            case "rss-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open","rss link");
                break;

            case "youtube-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce","youtube link");
                break;
        }
        Hooks.driver.close();

        Hooks.driver.switchTo().window(Tabs.get(0));
    }




}

