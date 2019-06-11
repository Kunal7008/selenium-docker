package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void search() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch("java");
        searchPage.goToVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size > 0);

    }
}

