package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    WebElement EMAIL_TXT;
    WebElement PASSWORD_TXT;
    WebElement CONTINUE_BUTTON;
    WebElement SIGN_IN_SUBMIT_BUTTON;

    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void login(String email, String password) {
        // Login to site with given email and password
        EMAIL_TXT = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        CONTINUE_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        EMAIL_TXT.clear();
        EMAIL_TXT.sendKeys(email);
        CONTINUE_BUTTON.click();
        PASSWORD_TXT = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        SIGN_IN_SUBMIT_BUTTON = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("signInSubmit")));
        PASSWORD_TXT.clear();
        PASSWORD_TXT.sendKeys(password);
        SIGN_IN_SUBMIT_BUTTON.click();
    }

}
