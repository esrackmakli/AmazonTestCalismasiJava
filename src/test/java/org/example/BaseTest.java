package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    static WebDriverWait webDriverWait;
    static MainPage mainPage;
    static LoginPage loginPage;
    static SearchPage searchPage;
    static ProductPage productPage;
    static WishlistPage wishlistPage;
    String email = "";
    String password = "";

    @BeforeClass
    public static void SetUp() {
        // Before the test methods worked, i configured the chrome driver and created models.
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(45));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        mainPage = new MainPage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
        searchPage = new SearchPage(driver, webDriverWait);
        productPage = new ProductPage(driver, webDriverWait);
        wishlistPage = new WishlistPage(driver, webDriverWait);
    }

    @AfterClass
    public static void tearDown() {
        // close the driver after test methods finish worked
        driver.quit();
    }

}
