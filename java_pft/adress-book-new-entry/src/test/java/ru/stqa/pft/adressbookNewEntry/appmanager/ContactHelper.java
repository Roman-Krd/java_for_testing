package ru.stqa.pft.adressbookNewEntry.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbookNewEntry.model.ContactData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {
    public boolean acceptNextAlert = true;

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void addNewEntryButton() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void addHomeInfo(String home) {
        type(By.name("home"), home);
    }

    public void addAddressInfo(String adress) {
        type(By.name("address"), adress);
    }

    public void addCompanyInfo(String company) {
        type(By.name("company"), company);
    }

    public void addTitleInfo(String title) {
        type(By.name("title"), title);
    }

    public void addExistingGroup(String group) {
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Test1");
        driver.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("lastname"), contactData.getLastmane());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("firstname"), contactData.getFirstname());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(ContactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void gotoNewEntryPage() {
        click(By.linkText("add new"));
    }


    public void deleteEntrySelected() {
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void checkboxEntryToDelete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectEntryToDelete(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void applyModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void selectEntry() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public boolean isThereANewEntry() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createNewEntry(ContactData newEntry, boolean b) {
        gotoNewEntryPage();
        fillContactForm(newEntry, b);
        addTitleInfo("1");
        addCompanyInfo("s7");
        addAddressInfo("Krasnodar");
        addHomeInfo("999");
        addNewEntryButton();
    }

    public int getContactCount() {

        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactsList() {
        ArrayList<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.name("selected[]"));
        for (WebElement element : elements) {
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

