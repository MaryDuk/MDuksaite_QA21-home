package com.telran.selenium.manager;

import com.telran.selenium.model.SearchData;
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

    public void searchData(SearchData text) throws InterruptedException {
      type(By.id("searchInput"), text.getSearchTitle());
      click(By.xpath("//input[@id='searchButton']"));
    }

    public boolean isSearchedElementPresent (String text){
        return isElementPresent(By.xpath("//b[contains(text(),'" + text + "')]"));
    }

    public String getTextOnWeb() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstHeading")));
        return driver.findElement(By.cssSelector("#firstHeading")).getText().toLowerCase();
    }
}
