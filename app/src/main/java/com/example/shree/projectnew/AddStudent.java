package com.example.shree.projectnew;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 14-11-2017.
 */

public class AddStudent extends AppCompatActivity {

    Activity activity;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);

        spinner = (Spinner) findViewById(R.id.addspinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.divisions);
        spinner.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.addSave);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertToDatabase(v);

            }

            private void InsertToDatabase(View v) {
                EditText name = (EditText) findViewById(R.id.addName);
                EditText roll = (EditText) findViewById(R.id.addRoll);
                EditText contact = (EditText) findViewById(R.id.addContact);
                String classSelected = spinner.getSelectedItem().toString();

                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Enter Name!");
                    return;
                }
                if((name.getText().toString().length()<2)||name.getText().toString().length()>15){
                    name.setError("InAppropriate name!");
                    return;
                }
                if(!name.getText().toString().matches("[a-zA-Z ]+"))
                {
                    name.requestFocus();
                    name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                if(TextUtils.isEmpty(roll.getText().toString())){
                    roll.setError("Enter RollNo");
                    return;
                }
                if(!roll.getText().toString().matches("[0-9]+"))
                {
                    roll.requestFocus();
                    roll.setError("ENTER ONLY NUMERICAL CHARACTER");
                }
                if((roll.getText().length()<4)||(roll.getText().length()>4))
                {
                    Toast.makeText(AddStudent.this,"Enter Valid RollNo! ",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(contact.getText().toString())){
                    contact.setError("Enter Contact ");
                    return;
                }
                if(!contact.getText().toString().matches("[789][0-9]\\d{8}$"))
                {
                    contact.requestFocus();
                    contact.setError("ENTER VALID CONTACT NUMBER");
                }

                else {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://" + Activity1.ip + ":8080/")
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    RetrofitService service = retrofit.create(RetrofitService.class);
                    Call<String> call = service.insertStud(classSelected,
                            name.getText().toString(), roll.getText().toString(), contact.getText().toString());


                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Log.e("RESPONSE", "*********" + response.body());
                            String success = response.body();
                            if (success.equals("1")) {
                                Toast.makeText(AddStudent.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(AddStudent.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.e("Error", t.toString());
                            Toast.makeText(AddStudent.this, "Failed", Toast.LENGTH_SHORT).show();

                        }


                    });
                }
            }
        });

        Button btnclear=(Button)findViewById(R.id.clrRecord);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText roll=(EditText)findViewById(R.id.addRoll);
                EditText name=(EditText)findViewById(R.id.addName);
                EditText contact=(EditText)findViewById(R.id.addContact);

                roll.setText("");
                name.setText("");
                contact.setText("");
            }
        });
    }
}

