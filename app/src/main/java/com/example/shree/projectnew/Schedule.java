 package com.example.shree.projectnew;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SHREE on 17-01-2018.
 */

public class Schedule {
    @SerializedName("Id")private Integer Id;
    @SerializedName("cl")private String cl;
    @SerializedName("day")private  String day;
    @SerializedName("subject")private String subject;
    @SerializedName("time_s")private String time_s;


    public Schedule(Integer Id,String cl, String day, String subject, String time_s) {
        this.Id=Id;
        this.cl = cl;
        this.day = day;
        this.subject = subject;
        this.time_s = time_s;
    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getcl() {
        return cl;
    }

    public void setcl(String cl) {
        this.cl = cl;
    }

    public String getday() {
        return day;
    }

    public void setday(String day) {
        this.day = day;
    }

    public String getsubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String gettime_s() {
        return time_s;
    }

    public void setContact(String time_s) {
        this.time_s = time_s;
    }
}
