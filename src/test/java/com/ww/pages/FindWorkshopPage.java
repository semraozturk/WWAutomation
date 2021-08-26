package com.ww.pages;

import com.ww.utils.BrowserUtils;
import com.ww.utils.ConfigurationReader;
import com.ww.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindWorkshopPage extends BasePage {


    @FindBy(className = "studioIcon-2TdMR")   //xpath = "//span[.='Studio']"
    private WebElement studioButton;

    @FindBy(id = "location-search")
    private WebElement searchField;

    @FindBy(className = "linkUnderline-1_h4g") // will return the first title in the search results
    private WebElement firstTitleInSearchResult;

    @FindBy(className = "distance-OhP63") // will return the first distance in the search results
    private WebElement firsDistanceInSearchResult;

    @FindBy(className = "linkUnderline-1_h4g") // will store all titles in the search result
    private List<WebElement> allTitlesInSearchResult;

    @FindBy(className = "distance-OhP63") // will store all distances in the search result
    private List<WebElement> allDistancesInSearchResult;

    static String titleInFirstSearchResult;
    static String distanceInFirstSearchResult;


    public void navigateToHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("app.homepage"));
        BrowserUtils.waitForPageLoad();
    }

    public void verifyPageTitle() {
        String expectedTextInTitle = "Find WW Studios & Meetings Near You | WW USA";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Actual and expected titles do not match! Actual title is :" + actualTitle,actualTitle.contains(expectedTextInTitle));
        System.out.println("Verified home page title! The title contains " + actualTitle);
    }

    public void clicksOnStudioButton() {
        BrowserUtils.clickOnElement(studioButton);
        System.out.println("Clicked on Studio Button!");
    }

    public void enterZipcodeInSearchField(String zipcode) {
        BrowserUtils.enterText(searchField,zipcode);
        searchField.sendKeys(Keys.ENTER);
    }

    public void getFirstTitleAndDistance() {
        titleInFirstSearchResult = firstTitleInSearchResult.getText().trim();
        distanceInFirstSearchResult = firsDistanceInSearchResult.getText().trim();
        System.out.println("The Title of the First Search Result = " + titleInFirstSearchResult);
        System.out.println("The Distance of the First Search Result = " + distanceInFirstSearchResult);
    }

    public void clickOnFirstSearchResult() {
        firstTitleInSearchResult.click();
    }







}




























