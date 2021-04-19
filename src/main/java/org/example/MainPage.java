package org.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    WebElement MAIN_PAGE_CONTROL;
    WebElement SIGN_IN_HOVER;
    WebElement SIGN_IN_BUTTON;
    WebElement LOGIN_PAGE;
    WebElement SEARCHBAR_TXT;
    String word = "samsung";
    WebElement SEARCH_BUTTON;
    WebElement SEARCH_RESULT;

    public MainPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void load_main_page() {
        // Navigates to the homepage and checks if it loaded
        webDriver.get("http://www.amazon.com.tr/");
        MAIN_PAGE_CONTROL = webDriver.findElement(By.id("gw-layout"));
        Assert.assertTrue("Here isn't main page!", MAIN_PAGE_CONTROL.isDisplayed());
    }

    public void load_login_page() {
        // loads the login page and checks if it loaded
        Actions action = new Actions(webDriver);
        SIGN_IN_HOVER = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
        action.moveToElement(SIGN_IN_HOVER).build().perform();
        SIGN_IN_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("nav-action-button")));
        SIGN_IN_BUTTON.click();
        LOGIN_PAGE = webDriver.findElement(By.className("a-spacing-small"));
        Assert.assertTrue("Here isn't login page!", LOGIN_PAGE.isDisplayed());
    }

    public void search_the_word() {
        // Enters the searched word in the search bar and searches, checks search result
        SEARCHBAR_TXT = webDriver.findElement(By.id("twotabsearchtextbox"));
        SEARCH_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
        SEARCHBAR_TXT.clear();
        SEARCHBAR_TXT.sendKeys(word);
        SEARCH_BUTTON.click();
        SEARCH_RESULT = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'samsung')]")));
        Assert.assertEquals("didn't found searched word!", SEARCH_RESULT.getText(), '"' + word + '"');
    }

}
