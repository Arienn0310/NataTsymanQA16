package com.tran.qa16;

public class ContactData {
    private String firstname;
    private String lastname;
    private String adress;

    public ContactData setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData setAdress(String adress) {
        this.adress = adress;
        return this;
    }


    public ContactData setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAdress() {
        return adress;
    }
}
