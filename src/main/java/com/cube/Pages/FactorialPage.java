package com.cube.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FactorialPage {

    WebDriver driver;

    @FindBy(id = "number")
    WebElement txtNumber;

    @FindBy(id = "getFactorial")
    WebElement btnGetFactorial;

    @FindBy(id = "resultDiv")
    WebElement results;

    @FindBy(xpath = "//a[normalize-space()='Terms and Conditions']")
    WebElement lblTermsandConditions;

    @FindBy(xpath = "//a[normalize-space()='Privacy']")
    WebElement lblPrivacy;

    @FindBy(xpath = "//a[normalize-space()='Qxf2 Services']")
    WebElement lblFooter;

    public FactorialPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, FactorialPage.class);
    }

    public void explicitWait(WebElement element) {
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NotFoundException nfe) {
            System.out.println("Error: " + nfe.getMessage() + ". In method name: " + new Object(){}.getClass().getEnclosingMethod());
        }
    }
    
    public void enterNumber(String number) {
        try {
            int factorialNumber = Integer.parseInt(number);
            explicitWait(txtNumber);
            txtNumber.sendKeys(number);
        } catch (NumberFormatException nfe) {
            System.out.println("Error: " + nfe.getMessage() + ". In method name: " + new Object() {
            }.getClass().getEnclosingMethod());
        }
    }

    public void calculateFactorial() {
        explicitWait(btnGetFactorial);
        btnGetFactorial.click();
        explicitWait(results);
    }

    public void termsandConditionsLink(String link, String message) {
        explicitWait(lblTermsandConditions);
        lblTermsandConditions.click();
        Assert.assertTrue(driver.getCurrentUrl().equals(link));
        Assert.assertNotEquals(driver.findElement(By.xpath("//body")).getText().contains(message), "Incorrect text.");
        System.out.println("T&C executed");
    }
    
    public void privacyLink(String link, String message) {
        explicitWait(lblPrivacy);
        lblPrivacy.click();
        Assert.assertTrue(driver.getCurrentUrl().equals(link));
        Assert.assertNotEquals(driver.findElement(By.xpath("//body")).getText().contains(message), "Incorrect text.");
        System.out.println("Privacy executed");
    }
    
    public void footerLink(String link) {
        lblFooter.click();
        Assert.assertTrue(driver.getCurrentUrl().equals(link));
        System.out.println("Service executed");
    }
}
