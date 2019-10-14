package com.telran.selenium.tests;

import com.telran.selenium.model.SearchData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchWikiTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> searchTitle(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Trafford Park"});
        list.add(new Object[]{"TRAFFORD PARK"});
        list.add(new Object[]{"trafford park"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object> searchTitlecsv() throws IOException {
        List <Object> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/SearchTitle.csv")));
        String line = reader.readLine();
        while (line!=null){
            SearchData searchData = new SearchData();
            list.add(searchData.setSearchTitle(line));
            line = reader.readLine();
        }
        return list.iterator();
    }



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

    @Test (dataProvider = "searchTitle")
    public void searchTestDP (String searchTitle) throws InterruptedException {
        SearchData text = new SearchData().setSearchTitle(searchTitle);
        app.getSearchHelper().searchData(text);
        String title = searchTitle.toLowerCase();
        String searchedText = app.getSearchHelper().getSearchText();
        Assert.assertEquals(searchedText, title);
    }
    @Test (dataProvider = "searchTitlecsv")
    public void searchTestDPcsv (SearchData text ) throws InterruptedException {
        app.getSearchHelper().searchData(text);;
        String searchedText = app.getSearchHelper().getSearchText();
        Assert.assertEquals(searchedText, text.getSearchTitle().toLowerCase());
    }

}
