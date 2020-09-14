package com.epam.pnTests;

import com.epam.common.pages.HomePage;
import com.epam.common.pages.SearchResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @BeforeClass
    public void initialize() {
//        initialize of driver e.g.Chrome
        WebDriverManager.chromedriver().browserVersion("84").setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void checkSearchPageOpeningAfterSearchQuery() {
        homePage.openPage();
        homePage.search("PS4");
        searchResultsPage.isPageLoaded();
        assertThat(searchResultsPage.isPageLoaded()).as("Search results Page wasn't loaded").isTrue();
    }


    @AfterClass
    public void stopDriver() {
        driver.close();
    }
}
