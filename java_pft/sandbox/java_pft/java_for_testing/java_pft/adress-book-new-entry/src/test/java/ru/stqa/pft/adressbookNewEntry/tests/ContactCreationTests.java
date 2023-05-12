package ru.stqa.pft.adressbookNewEntry.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbookNewEntry.appmanager.ContactHelper;
import ru.stqa.pft.adressbookNewEntry.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddressBookNewEntry() {
    app.getNavigationHepler().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().gotoNewEntryPage();
    app.getContactHelper().fillContactForm(new ContactData("Dimitri", "Vasilievich", "Dima", "Test1"), true);
    app.getContactHelper().addExistingGroup("Test1");
    app.getContactHelper().addTitleInfo("1");
    app.getContactHelper().addCompanyInfo("s7");
    app.getContactHelper().addAddressInfo("Krasnodar");
    app.getContactHelper().addHomeInfo("999");
    app.getContactHelper().addNewEntryButton();
    app.getNavigationHepler().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size()+1);
  }


}
