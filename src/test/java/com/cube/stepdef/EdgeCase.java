package com.cube.stepdef;

import com.cube.Core.BaseClass;
import com.cube.Pages.FactorialPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EdgeCase extends BaseClass {
    
    FactorialPage factorialPage = new FactorialPage(driver);

    @When("^user enter more than four \"([^\"]*)\"$")
    public void enterMoreThanFourDigits(String digits) {
        factorialPage.enterNumber(digits);
    }

    @Then("application provide no results or any type of message")
    public void resultsResponse() {
        factorialPage.calculateFactorial();
    }

}
