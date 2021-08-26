package com.ww.pages;

import com.ww.utils.BrowserUtils;
import com.ww.utils.ConfigurationReader;
import com.ww.utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);


    @FindBy(id = "bx-creative-1319834")
    private WebElement bestOfferModal;

    @FindBy(id = "bx-element-1319834-I49a6Rh")
    private WebElement modalNoThanksButton;


    public void handleRandomlyDisplayedModal(){
        try{
            if(bestOfferModal.isDisplayed()){
                BrowserUtils.clickOnElement(modalNoThanksButton);
                System.out.println("Clicked on No Thanks Button on the Model ");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Best Offer Modal was not displayed this time!");
        }

    }



}
