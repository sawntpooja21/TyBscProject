package com.example.shree.projectnew;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 24-01-2018.
 */

public class DeleteSchedule extends AppCompatActivity {
    Activity activity = this;
    ListView listView;
    EditText delschedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delschedule);
        listView=(ListView)findViewById(R.id.delList);
        delschedule=(EditText)findViewById(R.id.delId);

        Button showbtn=(Button)findViewById(R.id.delshow);
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etid1=delschedule.getText().toString();
                Integer id_1=Integer.parseInt(etid1);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                RetrofitService service = retrofit.create(RetrofitService.class);
                Call<List<Schedule>> call = service.getSchedule(id_1);

                call.enqueue(new Callback<List<Schedule>>() {
                    @Override

                    public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {

                        List<Schedule> jList = response.body();
                        String[] j_list = new String[jList.size()];
                        int i = 0;
                        for (Schedule schedule : jList) {
                            j_list[i] = "                   SCHEDULE DETAILS\n\n                       SUBJECT: "+schedule.getsubject().toUpperCase()+"\n\n                       ID "+ schedule.getId()+ "\n\n                       DAY: " + schedule.getday().toUpperCase() + "\n\n                       CLASS: "
                                    + schedule.getcl().toUpperCase()+"\n\n                       TIME: "+schedule.gettime_s()  ;

                        }
                        ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, j_list);
                        listView.setAdapter(adapter);
                    }


                    @Override
                    public void onFailure(Call<List<Schedule>> call, Throwable t) {
                        Log.e("Error", t.toString());
                        Toast.makeText(DeleteSchedule.this, "Failed", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
            }
        });


        Button btn=(Button)findViewById(R.id.delButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String etid=delschedule.getText().toString();
                Integer id_=Integer.parseInt(etid);
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                RetrofitService service = retrofit.create(RetrofitService.class);

                Call<Integer> call = service.deleteSchedule(id_);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        Log.e("RESPONSE", "*********" + response.body());
                        Integer success = response.body();
                        if (success.equals("0")) {
                            Toast.makeText(DeleteSchedule.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(DeleteSchedule.this, "Schedule deleted", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.e("Error", t.toString());
                        Toast.makeText(DeleteSchedule.this, "Failed", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}
