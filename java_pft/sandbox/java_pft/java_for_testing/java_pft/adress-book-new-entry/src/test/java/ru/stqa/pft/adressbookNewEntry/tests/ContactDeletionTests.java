package ru.stqa.pft.adressbookNewEntry.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbookNewEntry.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void tesLastEntryDeletion() throws Exception {

    app.getNavigationHepler().goToHomePage();
    if(! app.getContactHelper().isThereANewEntry()){
      app.getContactHelper().createNewEntry(new ContactData("Dimitri", "Vasilievich", "Dima", "Test1"), true);
      app.getNavigationHepler().goToHomePage();
    }

    List<String> before = app.getContactHelper().getContactsList();
    app.getContactHelper().selectEntryToDelete(before.size()-1);
    app.getContactHelper().checkboxEntryToDelete();
    app.getContactHelper().deleteEntrySelected();
    Thread.sleep(2000);
    app.getNavigationHepler().goToHomePage();
    Thread.sleep(2000);
    List<String> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size()-1);
  }

}
