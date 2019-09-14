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
    public void searchkTest ()  {
        app.search("TRAFFORD PARK");
        boolean isPresent = app.isSearchedElementPresent();
        Assert.assertEquals(isPresent, true);
    }

}
