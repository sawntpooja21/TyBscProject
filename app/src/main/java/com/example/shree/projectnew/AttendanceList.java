package com.example.shree.projectnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.example.shree.projectnew.R.id.checkbox;
import static com.example.shree.projectnew.R.id.textView;

/**
 * Created by SHREE on 22-01-2018.
 */
public class AttendanceList extends BaseAdapter {

    ArrayList<String> stdList;
    Activity activity;
    boolean box;
    BaseAdapter adapter;
    ArrayList<Attendance> attendanceList = new ArrayList<>();
    String date,hour,subject,Cls;
    public AttendanceList(Activity act, ArrayList<String> lst,String date, String hour, String subject,String Cls)
    {
        stdList = lst;
        activity = act;
        this.date = date;
        this.hour = hour;
        this.subject = subject;
        this.Cls=Cls;
    }
    @Override
    public int getCount() {
        return stdList.size();
    }

    @Override
    public Object getItem(int position) {
        return stdList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View v, ViewGroup parent) {
       final ViewHolder holder;

        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            v = vi.inflate(R.layout.attend_list, null);
            holder = new ViewHolder();

            v.setTag(holder);
        }
        else{
            holder = (ViewHolder) v.getTag();
        }
        final int pos = position;
        holder.txtText = (TextView) v.findViewById(R.id.attendanceName);
        holder.txtText.setText(stdList.get(position));
        holder.checkbox=(CheckBox)v.findViewById(R.id.attCheck);
        holder.checkbox.setTag(position);


        holder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.checkbox.isChecked()){
                    String roll = holder.txtText.getText().toString().substring(0,4);
                    String name=holder.txtText.getText().toString().substring(5);

                    attendanceList.add(new Attendance(roll,name,date,hour,subject,holder.checkbox.isChecked() + "",Cls));

                    //Log.d("Attendance", stdList.get(position).toString() + " is absent " + attendanceList.get(position));


                }
               /* else{
                    String roll = holder.txtText.getText().toString().substring(0,4);
                    String name=holder.txtText.getText().toString().substring(5);

                    attendanceList.add(new Attendance(roll,name,date,hour,subject,"false" + ""));
                }*/

            }
        });
        return v;


    }



    static class ViewHolder {
        TextView txtText;
        //TextView txtSubText;
        CheckBox checkbox;

    }


    public ArrayList getList(){

        return attendanceList;
    }


}
