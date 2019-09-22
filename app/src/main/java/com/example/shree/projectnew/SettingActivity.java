package com.example.shree.projectnew;

/**
 * Created by SHREE on 28-01-2018.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SettingActivity extends AppCompatActivity {
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstantance) {
        super.onCreate(savedInstantance);
        setContentView(R.layout.setting_activity);

        Button schedule,attendance;
        schedule=(Button)findViewById(R.id.clrSchedule);
        attendance=(Button)findViewById(R.id.clrAttendance);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(activity);
                alert.setTitle("Delete Schedule?");
                alert.setMessage("Do you want to delete all schedule ?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                                .addConverterFactory(GsonConverterFactory.create()).build();
                        RetrofitService service = retrofit.create(RetrofitService.class);

                        Call<String> call = service.clearSchedule();
                        call.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Log.e("RESPONSE", "*********" + response.body());
                                String success = response.body();
                                if (success.equals("1")) {
                                    Toast.makeText(SettingActivity.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(SettingActivity.this, "Schedule deleted", Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Log.e("Error", t.toString());
                                Toast.makeText(SettingActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();


            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(activity);
                alert.setTitle("Delete Attendance?");
                alert.setMessage("Do you want to delete all Attendance ?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                                .addConverterFactory(GsonConverterFactory.create()).build();
                        RetrofitService service = retrofit.create(RetrofitService.class);

                        Call<String> call = service.clearAttendance();
                        call.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Log.e("RESPONSE", "*********" + response.body());
                                String success = response.body();
                                if (success.equals("1")) {
                                    Toast.makeText(SettingActivity.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(SettingActivity.this, "Record Deleted", Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Log.e("Error", t.toString());
                                Toast.makeText(SettingActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();


            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.change_pwd, menu);
        return true;
    }
    public void changePass(MenuItem item) {
        Intent launchIntent  = new Intent(this,ChangePassword.class);
        startActivity(launchIntent);
    }


}
