package com.sanmarino.barangaysystem;

public class Resident {

    private String id, last, middle, first, suffix;
    private String contact, email, house, street, civil, birth;

    public Resident(String id, String last, String middle, String first,
                    String suffix, String contact, String email,
                    String house, String street, String civil, String birth) {

        this.id = id;
        this.last = last;
        this.middle = middle;
        this.first = first;
        this.suffix = suffix;
        this.contact = contact;
        this.email = email;
        this.house = house;
        this.street = street;
        this.civil = civil;
        this.birth = birth;
    }

    public String getId() { return id; }
    public String getLast() { return last; }
    public String getMiddle() { return middle; }
    public String getFirst() { return first; }
    public String getSuffix() { return suffix; }
    public String getContact() { return contact; }
    public String getEmail() { return email; }
    public String getHouse() { return house; }
    public String getStreet() { return street; }
    public String getCivil() { return civil; }
    public String getBirth() { return birth; }
}