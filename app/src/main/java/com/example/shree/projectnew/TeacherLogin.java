package com.example.shree.projectnew;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 20-11-2017.
 */

public class TeacherLogin extends AppCompatActivity {

    Button login;
    EditText uname,pwd;
    Activity activity=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);

        login=(Button)findViewById(R.id.LOGINbutton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=(EditText)findViewById(R.id.uname);
                pwd=(EditText)findViewById(R.id.pwd);

                /*Intent launchinIntent = new Intent(TeacherLogin.this, MainActivity.class);
                launchinIntent.putExtra("uname", uname.getText().toString());
                TeacherLogin.this.startActivity(launchinIntent);*/
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                RetrofitService service = retrofit.create(RetrofitService.class);

                Call<String> call = service.teacherLogin(uname
                        .getText().toString(),pwd.getText().toString());

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("RESPONSE","*********"+response.body());
                       String success = response.body();
                        //if (success.equals("1")) {
                        if(success.equals("1")){
                            //SharedPreference preference=new SharedPreference(TeacherLogin.this);
                            //preference.setName(success.getName());
                            Intent i=new Intent(activity,MainActivity.class);
                            startActivity(i);
                           finish();
                        } else {
                            Toast.makeText(TeacherLogin.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("Error",t.toString());
                        Toast.makeText(TeacherLogin.this, "Failed", Toast.LENGTH_SHORT).show();

                    }


                });

            }
        });

    }

}
