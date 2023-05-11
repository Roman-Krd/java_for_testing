package ru.stqa.pft.adressbookNewEntry.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.firefox.FirefoxCommandContext.CHROME;
import static org.openqa.selenium.remote.Browser.EDGE;
import static org.openqa.selenium.remote.Browser.FIREFOX;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class applicationManager {
    public WebDriver driver;
    public SessionHelper sessionHelper;
    public NavigationHepler navigationHepler;
    public ContactHelper contactHelper;
    public String baseUrl;

    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    public String browser;

    public applicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if (browser.equals(FIREFOX.browserName())) {
            driver = new FirefoxDriver();
        } else if (browser.equals(CHROME.name())) {
            driver = new ChromeDriver();
        } else if (browser.equals(EDGE.browserName())) {
            driver = new EdgeDriver();
        }
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        contactHelper = new ContactHelper(driver);
        navigationHepler = new NavigationHepler(driver);
        sessionHelper = new SessionHelper(driver);
        driver.get("http://localhost/addressbook/edit.php");
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
    }



    public boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHepler getNavigationHepler() {
        return navigationHepler;
    }

}
