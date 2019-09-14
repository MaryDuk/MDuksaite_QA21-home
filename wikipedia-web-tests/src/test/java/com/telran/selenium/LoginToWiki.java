package com.telran.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToWiki extends TestBase{

   @BeforeClass
   public void isOnHomePage () {
       if (!app.isWikiHomePageOpened()){
           app.openSite("https://en.wikipedia.org");
       }
   }

   @BeforeMethod
   public void isUserLoggedOff() {
       if (!app.isLoginPresent()){
           app.logOUt();
       }
   }

    @Test
    public void logInWiki () {
        app.login("MaryDuk", "trusty07");
        boolean isPresent = app.isLogoutPresent();
        Assert.assertEquals(isPresent, true);
    }
}
