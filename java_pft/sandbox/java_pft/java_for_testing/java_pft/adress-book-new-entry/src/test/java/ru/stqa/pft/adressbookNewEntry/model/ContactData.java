package ru.stqa.pft.adressbookNewEntry.model;


public class ContactData {
    private final String lastmane;
    private final String middlename;
    private final String firstname;
    private static String group;


    public ContactData(String lastmane, String middlename, String firstname, String group) {
        this.lastmane = lastmane;
        this.middlename = middlename;
        this.firstname = firstname;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastmane() {
        return lastmane;
    }

    public static String getGroup() {
        return group;
    }
}