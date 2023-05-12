package ru.stqa.pft.adressbookNewEntry.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbookNewEntry.model.ContactData;

import java.util.List;


public class ContactModificationTests extends TestBase{

    @Test
    public void newEntryModification() throws Exception{

        app.getNavigationHepler().goToHomePage();
        if(! app.getContactHelper().isThereANewEntry()){
            app.getContactHelper().createNewEntry(new ContactData("Dimitri", "Vasilievich", "Dima", "Test1"), true);
        }
        app.getNavigationHepler().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactsList();
        app.getContactHelper().selectEntry();
        app.getContactHelper().addTitleInfo("999");
        app.getContactHelper().addCompanyInfo("Ark");
        app.getContactHelper().addAddressInfo("New York");
        app.getContactHelper().addHomeInfo("100");
        app.getContactHelper().fillContactForm(new ContactData("Dimitri", "Vasilievich", "Dima", null), false);
        app.getContactHelper().applyModification();
        app.getNavigationHepler().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size());
     


    }
}
