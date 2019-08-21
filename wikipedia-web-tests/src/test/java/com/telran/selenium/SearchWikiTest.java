package com.telran.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchWikiTest {

    WebDriver driver;
    @Test
public void setUp () throws InterruptedException {

    driver = new ChromeDriver();
    driver.get("https://en.wikipedia.org");
    driver.findElement(By.id("searchInput")).click();
    driver.findElement(By.id("searchInput")).clear();
    driver.findElement(By.id("searchInput")).sendKeys("TRAFFORD PARK");
    driver.findElement(By.id("searchButton")).click();
    Thread.sleep(7000);
    driver.quit();

}

}
