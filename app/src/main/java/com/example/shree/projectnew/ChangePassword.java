package com.example.shree.projectnew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 03-02-2018.
 */

public class ChangePassword extends AppCompatActivity {
    EditText etName,newPass,cnfPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        final Button btnChange=(Button)findViewById(R.id.passButton);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName = (EditText) findViewById(R.id.pass_user);
                newPass = (EditText) findViewById(R.id.new_pass);
                cnfPass = (EditText) findViewById(R.id.cnfrm_pass);
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    etName.setError("Enter Username!");
                    return;
                }
                if(!etName.getText().toString().matches("[a-zA-Z ]+"))
                {
                    etName.requestFocus();
                    etName.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                if(TextUtils.isEmpty(newPass.getText().toString())){
                    newPass.setError("Enter Password!");
                    return;
                }

                if((newPass.getText().toString().length()<3)||newPass.getText().toString().length()>8){
                    newPass.setError("Password Size :4 to 8");
                    return;
                }

                if(TextUtils.isEmpty(cnfPass.getText().toString())){
                    cnfPass.setError("Confirm Your Password");
                    return;
                }

                else {
                    if (newPass.getText().toString().equals(cnfPass.getText().toString())) {

                        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://" + Activity1.ip + ":8080/")
                                .addConverterFactory(GsonConverterFactory.create()).build();
                        RetrofitService service = retrofit.create(RetrofitService.class);

                        Call<String> call = service.teacher_changePass(cnfPass.getText().toString(), etName.getText().toString());

                        call.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Log.e("RESPONSE", "*********" + response.body());
                                String success = response.body();
                                if (success.equals("1")) {
                                    Toast.makeText(ChangePassword.this, "Password Changed Successfully", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(ChangePassword.this, "Operation Failed", Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Log.e("Error", t.toString());
                                Toast.makeText(ChangePassword.this, "Failed", Toast.LENGTH_SHORT).show();

                            }


                        });
                    } else {
                        Toast.makeText(ChangePassword.this, "Please Confirm Your Password Again!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        Button btnclear=(Button)findViewById(R.id.passClear);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName=(EditText)findViewById(R.id.pass_user);
                newPass=(EditText)findViewById(R.id.new_pass);
                cnfPass=(EditText)findViewById(R.id.cnfrm_pass);

                etName.setText("");
                newPass.setText("");
                cnfPass.setText("");
            }
        });
    }


}
