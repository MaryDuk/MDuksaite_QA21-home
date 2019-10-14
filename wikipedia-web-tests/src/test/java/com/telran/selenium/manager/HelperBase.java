package com.telran.selenium.manager;

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

    public void type(By locator, String text) throws InterruptedException {
        if (text!=null){
            Thread.sleep(3000);
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }


}
