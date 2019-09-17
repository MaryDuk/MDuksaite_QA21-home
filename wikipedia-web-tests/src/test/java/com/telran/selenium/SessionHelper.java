package com.telran.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    public SessionHelper (WebDriver driver){
        super(driver);
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

    public boolean isLoginPresent (){
        return isElementPresent(By.xpath("//a[@accesskey='o']"));
    }

    public void logOUt(){
        click(By.xpath("//a[contains(text(),'Log out')]"));
    }

    public boolean isLogoutPresent(){
        return isElementPresent(By.xpath("//a[contains(text(),'Log out')]"));
    }

}
