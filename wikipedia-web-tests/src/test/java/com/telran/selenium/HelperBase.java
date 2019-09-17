package com.telran.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver driver;
public HelperBase (WebDriver driver){
    this.driver = driver;
}

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isWikiHomePageOpened() {
        return isElementPresent(By.xpath("//a[@class='mw-wiki-logo']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


}
