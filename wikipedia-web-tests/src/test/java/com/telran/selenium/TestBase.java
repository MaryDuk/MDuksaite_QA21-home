package com.telran.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {


    WebDriver driver;

    @BeforeMethod
    public void setUp ()  {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }

    public void clear(By locator) {
        driver.findElement(locator).clear();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String content) {
        driver.findElement(locator).sendKeys(content);
    }
}
