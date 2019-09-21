package com.telran.selenium.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    SessionHelper sessionHelper;
    SearchHelper searchHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }


    public void init() {
        if (browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }if (browser.equals(BrowserType.FIREFOX)){
            driver = new FirefoxDriver();
        }
        //driver = new ChromeDriver();
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
