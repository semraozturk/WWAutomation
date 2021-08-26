package com.ww.pages;

import com.ww.utils.BrowserUtils;
import com.ww.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class StudioDetailPage extends BasePage {

    @FindBy(className = "locationName-1jro_")
    private WebElement studioTitle;

    @FindBy(className = "title-3o8Pv")
    private WebElement businessHoursButton;

    @FindBy(className = "dayName-CTNC6")
    private List<WebElement> days;

    @FindBy(className = "times-fms3v")
    private List<WebElement> times;


    public void verifyDisplayedTitle(){
        String clickedTitle = FindWorkshopPage.titleInFirstSearchResult;
        String displayedTitle = studioTitle.getText().trim();
        Assert.assertEquals("Clicked and displayed titles do not match!",clickedTitle,displayedTitle);
        System.out.println("Verified the displayed title! The displayed title is : " + displayedTitle);
    }

    public void clickOnBusinessHoursButton(){
        BrowserUtils.clickOnElement(businessHoursButton);
        System.out.println("Clicked on Business Hours Menu!");
    }

    public void printAllBusinessHours(){
        List<String> allDays = BrowserUtils.getElementsText(days);
        List<String> allHours = BrowserUtils.getElementsText(times);

        for(int j=0; j < allDays.size(); j++){
            System.out.println(allDays.get(j) + "  " + allHours.get(j));
        }

    }




}
