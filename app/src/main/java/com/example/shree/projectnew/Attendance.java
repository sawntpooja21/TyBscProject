package com.example.shree.projectnew;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SHREE on 28-01-2018.
 */

public class Attendance {
    @SerializedName("RollNo")private String RollNo;
    @SerializedName("Name")private String Name;
    @SerializedName("date_")private  String date_;
    @SerializedName("hour")private String hour;
    @SerializedName("subj")private String subj;
    @SerializedName("isPresent")private String isPresent;
    @SerializedName("Cls")private String Cls;


    public Attendance(String RollNo,String Name, String date_, String hour,String subj,String isPresent,String Cls) {
        this.RollNo=RollNo;
        this.Name = Name;
        this.date_ = date_;
        this.hour=hour;
        this.subj = subj;
        this.isPresent= isPresent;
        this.Cls=Cls;
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


    public String getdate_() {
        return date_;
    }
    public void setdate_(String day) {
        this.date_ = date_;
    }


    public String gethour() {
        return hour;
    }
    public void sethour(String subj) {
        this.hour = hour;
    }


    public String getsubj() {
        return subj;
    }
    public void setsubj(String subj) {
        this.subj = subj;
    }


    public String getisPresent() {
        return isPresent;
    }
    public void setisPresent(String isPresent) {
        this.isPresent = isPresent;
    }

    public String getCls() {
        return Cls;
    }
    public void setCls(String isPresent) {
        this.Cls = Cls;
    }
}
