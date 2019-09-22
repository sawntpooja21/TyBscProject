package com.example.shree.projectnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHREE on 09-11-2017.
 */

public class SelectOption extends BaseAdapter {
    ArrayList  names;
    public static Activity activity;

    public SelectOption(Activity activity, ArrayList name)
    {
        this.activity=activity;
        this.names=name;
    }
    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            v = vi.inflate(R.layout.grid_layout, null);
        }
        TextView textView = (TextView)v.findViewById(R.id.namePlacer);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageHolder);
        if(names.get(position).toString().equals("ATTENDANCE"))
        {
            imageView.setImageResource(R.drawable.gridattendance);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = activity.getFragmentManager();
                    createRequest request = new createRequest();
                    request.show(fm,"Select");

                    /*Intent launchinIntent = new Intent(activity, TakeAttendance.class);
                    activity.startActivity(launchinIntent);*/
                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if(names.get(position).toString().equals("DELETE SCHEDULE")){
            imageView.setImageResource(R.drawable.delsch);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i=new Intent(activity,DeleteSchedule.class);
                    activity.startActivity(i);
                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if(names.get(position).toString().equals("SCHEDULER"))
        {
            imageView.setImageResource(R.drawable.schedulezz);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, schedular.class);
                    activity.startActivity(i);
                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }else if(names.get(position).toString().equals("STUDENT INFO"))
        {
            imageView.setImageResource(R.drawable.stud);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, StudentAttendanceInfo.class);
                    activity.startActivity(i);
                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if(names.get(position).toString().equals("SCHEDULER"))
        {
            //imageView.setImageResource(R.drawable.ic_attendance);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, schedular.class);
                    activity.startActivity(i);
                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }else if(names.get(position).toString().equals("SETTINGS"))
        {
            imageView.setImageResource(R.drawable.gridsetting);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, SettingActivity.class);
                    activity.startActivity(i);
                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if(names.get(position).toString().equals("LOGOUT")){
            imageView.setImageResource(R.drawable.gridlogout);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, TeacherLogin.class);
                    activity.startActivity(i);
                    activity.finish();

                }
            });
            Animation anim = new ScaleAnimation(
                    0.95f, 1f, // Start and end values for the X axis scaling
                    0.95f, 1f, // Start and end values for the Y axis scaling
                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                    Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
            anim.setFillAfter(true); // Needed to keep the result of the animation
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        textView.setText(names.get(position).toString());
        return v;
    }
    public static class createRequest extends DialogFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Get the layout inflater
            LayoutInflater inflater = getActivity().getLayoutInflater();
            final View v = inflater.inflate(R.layout.set_date_time, null);
            final DatePicker datePicker = (DatePicker) v.findViewById(R.id.setdate);
            final EditText hour = (EditText) v.findViewById(R.id.hour);
            final Spinner spn = (Spinner) v.findViewById(R.id.setSubject);
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://"+Activity1.ip+":8080/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            RetrofitService service = retrofit.create(RetrofitService.class);
            Call<List<Schedule>> call = service.spinnerSchedule();

            call.enqueue(new Callback<List<Schedule>>() {
                @Override

                public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {

                    List<Schedule> jList = response.body();
                    String[] j_list = new String[jList.size()];
                    int i = 0;
                    for (Schedule schedule : jList) {
                        j_list[i] = schedule.getsubject();
                        i++;
                    }
            ArrayAdapter<String> adapterSpinner = new ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, j_list){
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    if (position % 2 == 0) { // we're on an even row
                        view.setBackgroundColor(Color.parseColor("#66b0fc"));
                    } else {
                        view.setBackgroundColor(Color.parseColor("#a7d2fd"));
                    }
                    return view;
                }
            };
            assert spn != null;
            spn.setAdapter(adapterSpinner);
                }
                @Override
                public void onFailure(Call<List<Schedule>> call, Throwable t) {
                    Log.e("Error", t.toString());
                    /*Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();*/
                    t.printStackTrace();
                }
                });
            builder.setView(v)
                    // Add action buttons
                    .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                            int day = datePicker.getDayOfMonth();
                            int month = datePicker.getMonth() + 1;
                            int year = datePicker.getYear();
                            String date = year + "-" + month + "-" + day;

                            String subject = spn.getSelectedItem().toString();
                            //DatePickerDialog dpd = new DatePickerDialog(getActivity(),AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this,year,month,day);
                            datePicker.setMinDate(System.currentTimeMillis() - 1000);
                            Intent launchinIntent = new Intent(MainActivity.activity, TakeAttendance.class);
                            launchinIntent.putExtra("DATE", date);
                            launchinIntent.putExtra("PERIOD", hour.getText().toString());
                            launchinIntent.putExtra("SUBJECT",subject);
                            MainActivity.activity.startActivity(launchinIntent);
                        }
                        })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }

            });

            return builder.create();
        }


    }
}
