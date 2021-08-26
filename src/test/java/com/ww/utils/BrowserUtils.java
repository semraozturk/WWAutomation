package com.ww.utils;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    private static WebDriverWait wait = new WebDriverWait(com.ww.utils.Driver.getDriver(),20);


    public static void wait(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element,"value",text));
        System.out.println("Entering text: " + text);
    }

    public static void waitForPageLoad(){
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }

    public static List<String> getElementsText(List<WebElement> list){
        List<String> webElementsTexts = new ArrayList<>();

        for(WebElement eachElement: list){
            webElementsTexts.add(eachElement.getText());
        }
        return webElementsTexts;
    }


}
