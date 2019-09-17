package com.telran.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchWikiTest extends TestBase{

    @BeforeClass
    public void isOnHomePage () {
        if (!app.getSearchHelper().isWikiHomePageOpened()){
            app.getSessionHelper().openSite("https://en.wikipedia.org");
        }
    }
    @Test
    public void searchTest ()  {
        String title = "Trafford Park";
        app.getSearchHelper().search(title);
        boolean isPresent = app.getSearchHelper().isSearchedElementPresent(title);
        Assert.assertEquals(isPresent, true);
    }


}
