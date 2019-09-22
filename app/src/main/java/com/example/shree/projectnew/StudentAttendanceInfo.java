package com.example.shree.projectnew;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 14-11-2017.
 */

public class StudentAttendanceInfo extends AppCompatActivity {


    ListView listView;
    ArrayList<String> dates;
    ArrayList<String> datesALONE;
    ArrayList<Integer> hourALONE;
    ArrayList<Boolean> atts;
    Activity activity =this;
    private View v;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud_info);
        dates = new ArrayList<>();
        datesALONE = new ArrayList<>();
        hourALONE = new ArrayList<>();
        atts = new ArrayList<>();
        listView = (ListView) findViewById(R.id.attendProfileView_list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = new Intent(activity, AddStudent.class);
                startActivity(launchIntent);
            }
        });
        //TextView textView = (TextView)findViewById(R.id.profileView);
        //assert textView != null;

        Button findButton = (Button)findViewById(R.id.showStudent);
        assert findButton != null;
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showStudent();
                EditText roll=(EditText)findViewById(R.id.etRoll);
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                RetrofitService service = retrofit.create(RetrofitService.class);
                Call<List<Student>> call = service.showStud(roll.getText().toString());

                call.enqueue(new Callback<List<Student>>() {
                    @Override

                    public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                        List<Student> jList = response.body();
                        String[] j_list = new String[jList.size()];
                        int i = 0;
                        for (Student student : jList) {
                            j_list[i] = "               STUDENT DETAILS\n\n                ROLLNO: "+student.getRollNo().toUpperCase()+"\n\n                CLASS: "+ student.getClss().toUpperCase() + "\n\n                NAME: " + student.getName().toUpperCase() + "\n\n                CONTACT: "
                                    + student.getContact().toUpperCase()+"\n\n\n\n\n\n\n\n\n\n\n"  ;
                            i++;
                        }
                        ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, j_list)
                        {
                            @Override
                            public View getView(int position, View convertView, ViewGroup parent){

                            View view = super.getView(position, convertView, parent);

                            TextView textview = (TextView) view.findViewById(android.R.id.text1);

                            //Set your Font Size Here.
                            textview.setTextSize(20);
                                textview.setTextColor(Color.parseColor("#12477d"));

                            return view;
                        }
                        };
                        listView.setAdapter(adapter);
                    }


                    @Override
                    public void onFailure(Call<List<Student>> call, Throwable t) {
                        Log.e("Error", t.toString());
                        Toast.makeText(StudentAttendanceInfo.this, "Failed", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.update_student_menu, menu);
        return true;
    }
    public void editStudent(MenuItem item) {
        Intent launchIntent  = new Intent(this,UpdateStudent.class);
        startActivity(launchIntent);
    }

    }