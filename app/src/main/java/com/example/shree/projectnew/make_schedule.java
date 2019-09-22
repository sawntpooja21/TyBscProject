package com.example.shree.projectnew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 09-11-2017.
 */

public class make_schedule extends AppCompatActivity {
    Spinner classSelect,daySelect;
    ArrayAdapter adapterSpinner, days;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_schedule);

        classSelect = (Spinner)findViewById(R.id.selectclass);
        daySelect = (Spinner)findViewById(R.id.selectday);

        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.divisions);
        assert classSelect != null;
        classSelect.setAdapter(adapterSpinner);

        ArrayList<String> weekdays = new ArrayList<>();
        weekdays.add("MONDAY");
        weekdays.add("TUESDAY");
        weekdays.add("WEDNESDAY");
        weekdays.add("THURSDAY");
        weekdays.add("FRIDAY");
        weekdays.add("SATURDAY");
        weekdays.add("SUNDAY");
        days = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, weekdays);
        assert classSelect != null;
        daySelect.setAdapter(days);

        Button btn = (Button)findViewById(R.id.saveSCHEDULE);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSchedule(v);
            }

            private void saveSchedule(View v) {
                String daySelected = daySelect.getSelectedItem().toString();
                String classSelected = classSelect.getSelectedItem().toString();
                EditText editText = (EditText)findViewById(R.id.subject);
                String subject = editText.getText().toString();
                TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
                int hour = timePicker.getCurrentHour();

                int min = timePicker.getCurrentMinute();
                if(TextUtils.isEmpty(editText.getText().toString())){
                    editText.setError("Enter Subject name");
                    return;
                }

                if(subject.length()<2)
                {
                    Toast.makeText(getBaseContext(),"Enter Valid Subject Name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!editText.getText().toString().matches("[a-zA-Z ]+"))
                {
                    editText.requestFocus();
                    editText.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                else {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://" + Activity1.ip + ":8080/")
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    RetrofitService service = retrofit.create(RetrofitService.class);
                    Call<String> call = service.insertSchedule(classSelected, daySelected, subject, hour + ":" + min);
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Log.e("RESPONSE", "*********" + response.body());
                            String success = response.body();
                            if (success.equals("1")) {
                                Toast.makeText(make_schedule.this, "Schedule created Successfully", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(make_schedule.this, "Operation Failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.e("Error", t.toString());
                            Toast.makeText(make_schedule.this, "Failed", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });

    }
}

