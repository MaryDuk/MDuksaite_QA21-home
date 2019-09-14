package com.telran.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchWikiTest extends TestBase{

    @BeforeClass
    public void isOnHomePage () {
        if (!app.isWikiHomePageOpened()){
            app.openSite("https://en.wikipedia.org");
        }
    }
    @Test
    public void searchTest ()  {
        String title = "Trafford Park";
        app.search(title);
        boolean isPresent = app.isSearchedElementPresent(title);
        Assert.assertEquals(isPresent, true);
    }

}
