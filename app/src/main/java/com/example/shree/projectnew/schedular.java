package com.example.shree.projectnew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 09-11-2017.
 */

public class schedular extends AppCompatActivity {
    ListView listView;

    /*ArrayList<String> subs;
    ArrayList<String> subx;
    ArrayList<String> times;*/

    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_sch);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = new Intent(getBaseContext(), make_schedule.class);
                startActivity(launchIntent);
            }
        });
        loadSchedules();
        /*subs = new ArrayList<>();
        times = new ArrayList<>();
        subx = new ArrayList<>();*/


        listView = (ListView) findViewById(R.id.schedulerList);
        //listView.setOnItemLongClickListener(this);
    }


    private void loadSchedules() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://" + Activity1.ip + ":8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<List<Schedule>> call = service.getAllSchedule();

        call.enqueue(new Callback<List<Schedule>>() {
            @Override

            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {

                List<Schedule> jList = response.body();
                String[] j_list = new String[jList.size()];
                int i = 0;
                for (Schedule schedule : jList) {
                    j_list[i] = schedule.getId() + " " + schedule.getcl() + " " + schedule.getday() + " "
                            + schedule.gettime_s() + " " + schedule.getsubject();
                    i++;
                }
                final ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, j_list) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        // Get the current item from ListView
                        View view = super.getView(position, convertView, parent);
                        if (position % 2 == 1) {
                            // Set a background color for ListView regular row/item
                            view.setBackgroundColor(Color.parseColor("#66b0fc"));
                        } else {
                            // Set the background color for alternate row/item
                            view.setBackgroundColor(Color.parseColor("#a7d2fd"));
                        }
                        return view;
                    }

                };

                listView.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<List<Schedule>> call, Throwable t) {
                Log.e("Error", t.toString());
                Toast.makeText(schedular.this, "Failed", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    /*public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        String a;

        Schedule schedule = new Schedule();
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Delete Schedule?");
        alert.setMessage("Do you want to delete this schedule ?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.43.60:8080/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                RetrofitService service = retrofit.create(RetrofitService.class);

                Call<Integer> call = service.deleteSchedule(schedule.getId());
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        Log.e("RESPONSE", "*********" + response.body());
                        Integer success = response.body();
                        if (success.equals("1")) {
                            Toast.makeText(schedular.this, "Schedule deleted", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(schedular.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.e("Error", t.toString());
                        Toast.makeText(schedular.this, "Failed", Toast.LENGTH_SHORT).show();

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
        return true;
    }
*/

    public void refresh(MenuItem item) {

        loadSchedules();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.scheduler_menu, menu);
        return true;
    }
}
