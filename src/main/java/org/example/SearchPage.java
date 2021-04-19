package org.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    WebElement SECOND_PAGE;
    WebElement SECOND_PAGE_CONTROL;
    WebElement SECOND_PRODUCT;
    WebElement PRODUCT_PAGE_CONTROL;

    public SearchPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void load_second_page() {
        // Loads second search page and checks if it is true page
        SECOND_PAGE = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("a-normal")));
        SECOND_PAGE.click();
        SECOND_PAGE_CONTROL = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("2")));
        Assert.assertNotNull("Here isn't second page!", SECOND_PAGE_CONTROL);
    }

    public void load_second_product() {
        // Loads second product page and checks if it loaded success
        SECOND_PRODUCT = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("a-link-normal s-no-outline"))).get(1);
        SECOND_PRODUCT.click();
        PRODUCT_PAGE_CONTROL = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
        Assert.assertTrue("Here isn't product page!", PRODUCT_PAGE_CONTROL.isDisplayed());
    }
}