package org.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    WebElement WISHLIST_BUTTON;
    WebElement CREATE_LIST_BUTTON;
    WebElement POP_UP_CLOSE_BUTTON;
    WebElement HOVER_ELEMENT;
    WebElement WISHLIST;
    WebElement WISHLIST_PAGE_CONTROL;

    public ProductPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void add_to_product_wishlist() {
        // Add to product wishlist
        WISHLIST_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-wishlist-button-submit")));
        WISHLIST_BUTTON.click();
        CREATE_LIST_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("wl-redesigned-create-list")));
        CREATE_LIST_BUTTON.click();
        POP_UP_CLOSE_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("a-button-close")));
        POP_UP_CLOSE_BUTTON.click();
    }

    public void load_wishlist_page() {
        // Go to wishlist page and checks
        Actions action = new Actions(webDriver);
        HOVER_ELEMENT = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
        action.moveToElement(HOVER_ELEMENT).build().perform();
        WISHLIST = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("nav-text"))).get(0);
        WISHLIST_PAGE_CONTROL = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-list-name")));
        Assert.assertTrue("Here isn't wishlist page!", WISHLIST_PAGE_CONTROL.isDisplayed());
    }
}
