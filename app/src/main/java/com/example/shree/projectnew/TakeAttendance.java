package com.example.shree.projectnew;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 17-11-2017.
 */

public class TakeAttendance extends AppCompatActivity {

    ListView listView;
    AttendanceList adapter;
    ArrayList<String> names;
    ArrayList<String> roll;
    Activity thisActivity = this;
    Spinner spinner;

    ArrayAdapter<String> adapterSpinner;
    public String hour,date_,subj,roll_,name,check;
    @Override
    protected void onCreate(Bundle savedInstantance){
        super.onCreate(savedInstantance);
        setContentView(R.layout.take_attendance);


        date_ = getIntent().getStringExtra("DATE");
        hour = getIntent().getStringExtra("PERIOD");
        subj=getIntent().getStringExtra("SUBJECT");

        Log.d("Attendance", date_ + " -- " + hour+"--"+subj);
        listView = (ListView) findViewById(R.id.studentList);
        /*names = new ArrayList<>();
        roll = new ArrayList<>();*/

        Button btn = (Button)findViewById(R.id.Show_Class);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListView(v);
            }
        });


        spinner = (Spinner) findViewById(R.id.takeattendancespinner);
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);


        Button savbtn=(Button)findViewById(R.id.SaveAttendance);
        savbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(thisActivity, "ButtonPressed", Toast.LENGTH_SHORT).show();

                ArrayList<Attendance> attendanceList = adapter.getList();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://"+Activity1.ip+":8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RetrofitService service = retrofit.create(RetrofitService.class);

                Call<String> call = service.takeAttendance(attendanceList);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(TakeAttendance.this, "Successfully Saved ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(TakeAttendance.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

    }
    public void loadListView(final View view) {
        //names.clear();
        //roll.clear();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<List<Student>> call = service.showclss(spinner.getSelectedItem().toString());

        call.enqueue(new Callback<List<Student>>() {
            @Override

            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                List<Student> jList = response.body();

                ArrayList<String> j_list= new ArrayList<String>();
                int i = 0;
                for (Student student : jList) {
                    j_list.add(student.getRollNo() + " " + student.getName());
                    i++;
                }
                adapter = new AttendanceList(thisActivity, j_list,date_,hour,subj,spinner.getSelectedItem().toString()){
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
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.e("Error", t.toString());
                Toast.makeText(TakeAttendance.this, "Failed", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

        Call<String> call1 = service.lectCount(subj,date_,spinner.getSelectedItem().toString());


        call1.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call1, Response<String> response) {
                Log.e("RESPONSE","*********"+response.body());
                String success = response.body();
                if (success.equals("1")) {
                    Toast.makeText(TakeAttendance.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(TakeAttendance.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<String> call1, Throwable t) {
                Log.e("Error",t.toString());
                Toast.makeText(TakeAttendance.this, "Failed", Toast.LENGTH_SHORT).show();

            }


        });
    }
}
