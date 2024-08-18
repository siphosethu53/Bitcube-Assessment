package com.cube.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    protected WebDriver driver;

    public void initBrowser() {
        driver = new ChromeDriver();
        driver.navigate().to("https://qainterview.pythonanywhere.com/");
        driver.manage().window().maximize();
    }
    
    public void tearDownBrowser() {
        driver.close();
        driver.quit();
    }
}