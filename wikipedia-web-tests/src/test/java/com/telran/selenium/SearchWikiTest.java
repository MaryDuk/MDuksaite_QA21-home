package com.telran.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchWikiTest extends TestBase{

    @Test
    public void searchTrafforParkTest () throws InterruptedException {
        driver.get("https://en.wikipedia.org");
        click(By.id("searchInput"));
        clear(By.id("searchInput"));
        type(By.id("searchInput"), "TRAFFORD PARK"+ Keys.ENTER);
        //driver.findElement(By.id("searchButton")).click();
        Thread.sleep(7000);
    }

}
