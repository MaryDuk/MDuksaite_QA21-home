package com.telran.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    SessionHelper sessionHelper;
    SearchHelper searchHelper;


    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        sessionHelper = new SessionHelper(driver);
        searchHelper = new SearchHelper(driver);

        sessionHelper.openSite("https://en.wikipedia.org");
    }

    public void stop() {
        driver.quit();
    }


    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }
}
