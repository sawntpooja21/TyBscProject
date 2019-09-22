package com.example.shree.projectnew;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SHREE on 31-01-2018.
 */

public class SharedPreference {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    int Private_mode=0;
    private static final String pref_name="uname";
    private static final String UNAME_KEY="uname";

    public SharedPreference(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences(pref_name,Private_mode);
        editor=sharedPreferences.edit();
    }

    public String getUname() {
        return sharedPreferences.getString(UNAME_KEY,null);
    }

    public void setUname(String uname){
        editor.putString(UNAME_KEY,null);
        editor.commit();
    }
}
