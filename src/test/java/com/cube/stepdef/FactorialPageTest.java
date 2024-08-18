package com.cube.stepdef;

import com.cube.Core.BaseClass;
import com.cube.Pages.FactorialPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
public class FactorialPageTest extends BaseClass{

    FactorialPage factorialPage = new FactorialPage(driver);

    @Given("^user is on the home page \"([^\"]*)\"$")
    public void landing_page(String url) {
        initBrowser();
    }

    @When("^user enter a positive whole number \"([^\"]*)\"$")
    public void user_enter_a_positive_whole_number(String number) {
        factorialPage.enterNumber(number);

    }

    @And("user click on calculate button")
    public void user_click_on_calculate_button(){
        factorialPage.calculateFactorial();
    }

    @And("user close browser")
    public void close_browser(){
        tearDownBrowser();
    }    
}
