package com.telran.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginToWiki extends TestBase{
    @Test
    public void logInWiki () throws InterruptedException {
        driver.get("https://en.wikipedia.org");

        click(By.id("pt-login"));

        click(By.id("wpName1"));
        clear(By.id("wpName1"));
        type(By.id("wpName1"), "ASDFG");

        click(By.id("wpPassword1"));
        clear(By.id("wpPassword1"));
        type(By.id("wpPassword1"), "123456");

        click(By.id("wpRemember"));

        click(By.id("wpLoginAttempt"));

        Thread.sleep(7000);

    }

}
