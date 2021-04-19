package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    WebElement WISHLIST_PRODUCT;
    WebElement DELETE_BUTTON;
    WebElement DELETE_CONTROL;

    public WishlistPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void delete_product_wishlist() {
        // Delete the product wishlist and checks if it deleted successfully
        WISHLIST_PRODUCT = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("g-span12when-narrow")));
        DELETE_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("submit.deleteItem")));
        Assert.assertTrue("There isn't product in wishlist!", WISHLIST_PRODUCT.isDisplayed());
        DELETE_BUTTON.click();
        DELETE_CONTROL = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("a-alert-content"))).get(10);
        Assert.assertTrue("Didn't deleted the product from wishlist!", DELETE_CONTROL.isDisplayed());
    }
}
