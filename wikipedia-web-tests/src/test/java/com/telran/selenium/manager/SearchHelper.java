package com.telran.selenium.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHelper extends HelperBase{

    public SearchHelper(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        driver.findElement(By.id("searchInput")).click();
        driver.findElement(By.id("searchInput")).clear();
        driver.findElement(By.id("searchInput")).sendKeys(text + Keys.ENTER);
    }

    public boolean isSearchedElementPresent (String text){
        return isElementPresent(By.xpath("//b[contains(text(),'" + text + "')]"));
    }

    protected String getSearchText() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        return driver.findElement(By.cssSelector("h1")).getText();
    }
}
