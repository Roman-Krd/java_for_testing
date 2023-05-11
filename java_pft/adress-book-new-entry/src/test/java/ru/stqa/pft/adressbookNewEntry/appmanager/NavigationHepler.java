package ru.stqa.pft.adressbookNewEntry.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHepler extends HelperBase {
    public NavigationHepler(WebDriver driver) {
        super(driver);
    }
    public void goToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
            click(By.linkText("home"));
        System.out.println();
    }


}