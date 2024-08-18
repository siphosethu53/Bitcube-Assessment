package com.cube.stepdef;

import com.cube.Core.BaseClass;
import com.cube.Pages.FactorialPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HyperLinkPage extends BaseClass{

    FactorialPage factorialPage = new FactorialPage(driver);

    @When("^user click on a \"([^\"]*)\" and is redirected to \"([^\"]*)\" and the incorrect \"([^\"]*)\" is displayed$")
    public void user_click_on_a_hyperlink(String hyperlink, String url, String message) {
        switch (hyperlink) {
            case "Terms and Conditions": factorialPage.termsandConditionsLink(url, message); break;
            case "Privacy": factorialPage.privacyLink(url, message); break;
            case "Qxf2 Services": factorialPage.footerLink(url); break;
        }
    }

    @Then("user close browser")
    public void close_browser(){
        tearDownBrowser();
    }    
}
