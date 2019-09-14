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

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        openSite("https://en.wikipedia.org");
    }

    public void stop() {
        driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void login(String login, String password) {
        click(By.id("pt-login"));
        click(By.id("wpName1"));
        driver.findElement(By.id("wpName1")).clear();
        driver.findElement(By.id("wpName1")).sendKeys(login);
        click(By.id("wpPassword1"));
        driver.findElement(By.id("wpPassword1")).clear();
        driver.findElement(By.id("wpPassword1")).sendKeys(password);
        click(By.id("wpRemember"));
        click(By.id("wpLoginAttempt"));
    }

    public void search(String text) {
        driver.findElement(By.id("searchInput")).click();
        driver.findElement(By.id("searchInput")).clear();
        driver.findElement(By.id("searchInput")).sendKeys(text + Keys.ENTER);
    }

    public boolean isWikiHomePageOpened() {
        return isElementPresent(By.xpath("//a[@class='mw-wiki-logo']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isLoginPresent (){
        return isElementPresent(By.xpath("//a[@accesskey='o']"));
    }

    public void logOUt(){
        click(By.xpath("//a[contains(text(),'Log out')]"));
    }

    public boolean isLogoutPresent(){
        return isElementPresent(By.xpath("//a[contains(text(),'Log out')]"));
    }

    public boolean isSearchedElementPresent (String text){
        return isElementPresent(By.xpath("//b[contains(text(),'" + text + "')]"));
    }

    protected String getSearchText() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        return driver.findElement(By.cssSelector("h1")).getText();
    }
}
