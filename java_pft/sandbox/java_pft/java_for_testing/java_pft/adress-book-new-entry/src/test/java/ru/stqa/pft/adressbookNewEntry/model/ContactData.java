package ru.stqa.pft.adressbookNewEntry.model;


import java.util.Objects;

public class ContactData {
    private final String lastname;
    private final String middlename;
    private final String firstname;
    private static String group;


    public ContactData(String lastmane, String middlename, String firstname, String group) {
        this.lastname = lastmane;
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

    public String getLastname() {
        return lastname;
    }

    public static String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "lastmane='" + lastname + '\'' +
                '}';
    }
}