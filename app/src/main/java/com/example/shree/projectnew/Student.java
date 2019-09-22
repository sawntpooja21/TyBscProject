package com.example.shree.projectnew;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SHREE on 09-01-2018.
 */

public class Student {
    @SerializedName("Clss")private String Clss;
    @SerializedName("RollNo")private  String RollNo;
    @SerializedName("Name")private String Name;
    @SerializedName("Contact")private String Contact;


    public Student(String Clss, String RollNo, String Name, String Contact) {
        this.Clss = Clss;
        this.RollNo = RollNo;
        this.Name = Name;
        this.Contact = Contact;
    }

    public String getClss() {
        return Clss;
    }

    public void setClss(String Clss) {
        this.Clss = Clss;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.RollNo = RollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }



    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }
}
