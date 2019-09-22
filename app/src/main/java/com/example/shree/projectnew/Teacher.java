package com.example.shree.projectnew;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SHREE on 31-01-2018.
 */

public class Teacher {
    @SerializedName("uname")private String name;
    @SerializedName("pass")private String pass;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
