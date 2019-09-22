package com.example.shree.projectnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by SHREE on 20-11-2017.
 */

public class FirstPage extends AppCompatActivity {
    Activity activity=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                    startActivity(new Intent(FirstPage.this,TeacherLogin.class));
                    finish();
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
