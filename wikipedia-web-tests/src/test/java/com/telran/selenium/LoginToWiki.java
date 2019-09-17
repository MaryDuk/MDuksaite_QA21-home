package com.telran.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToWiki extends TestBase{

   @BeforeClass
   public void isOnHomePage () {
       if (!app.getSessionHelper().isWikiHomePageOpened()){
           app.getSessionHelper().openSite("https://en.wikipedia.org");
       }
   }

   @BeforeMethod
   public void isUserLoggedOff() {
       if (!app.getSessionHelper().isLoginPresent()){
           app.getSessionHelper().logOUt();
       }
   }

    @Test
    public void logInWiki () {
        app.getSessionHelper().login("MaryDuk", "trusty07");
        boolean isPresent = app.getSessionHelper().isLogoutPresent();
        Assert.assertEquals(isPresent, true);
    }
}
