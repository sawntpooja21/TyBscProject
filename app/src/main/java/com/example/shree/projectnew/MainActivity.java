package com.example.shree.projectnew;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> basicFields;
    SelectOption adapter;
    public static ArrayList<String> divisions ;
    GridView gridView;
    public static Activity activity;
    String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        activity=this;
       // uname = getIntent().getStringExtra("uname");
       // SharedPreference pref=new SharedPreference(this);
        //TextView tv=(TextView)findViewById(R.id.textView3);
        //tv.setText("Welcome "+pref.getUname());

        //tv.setText(sharedPreference.getUname());
        getSupportActionBar().show();
        divisions = new ArrayList();
        divisions.add("FYBsc");
        divisions.add("SYBsc");
        divisions.add("TYBsc");
        divisions.add("MscCsI");
        divisions.add("MscCsII");


        basicFields = new ArrayList<>();
        gridView = (GridView)findViewById(R.id.grid);
        basicFields.add("ATTENDANCE");
        basicFields.add("SCHEDULER");
        basicFields.add("DELETE SCHEDULE");
        basicFields.add("STUDENT INFO");
        basicFields.add("SETTINGS");
        basicFields.add("LOGOUT");
        adapter = new SelectOption(this,basicFields);
        gridView.setAdapter(adapter);
    }
}
