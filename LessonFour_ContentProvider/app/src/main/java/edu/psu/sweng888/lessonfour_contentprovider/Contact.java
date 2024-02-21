package edu.psu.sweng888.lessonfour_contentprovider;

public class Contact {

    private String mName;
    private String mPhoneNumber;

    public Contact(String name, String phoneNumber) {
        mName = name;
        mPhoneNumber = phoneNumber;
    }

    public String getName() {
        return mName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }
}
