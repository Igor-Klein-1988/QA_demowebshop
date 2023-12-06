package com.ait.demowebshop.framework;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

@Getter
public class ApplicationManager {
    @Getter(AccessLevel.NONE)
    String browser;

    @Getter(AccessLevel.NONE)
    WebDriver driver;

    UserHelper user;

    HomePageHelper homePage;

    CartHelper cart;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        homePage = new HomePageHelper(driver);
        cart = new CartHelper(driver);

    }

    public void stop() {
        driver.quit();
    }
}
