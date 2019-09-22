package com.example.shree.projectnew;

/**
 * Created by SHREE on 09-01-2018.
 */
import java.net.ServerSocket;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @POST("Admin_Attendance/teacherLogin.jsp")
    @FormUrlEncoded
    Call<String>teacherLogin(@Query("uname") String uname,
                           @Field("pass")String pass);

    @GET("Admin_Attendance/getAllSchedule.jsp")
    Call<List<Schedule>>getAllSchedule();

    @GET("Admin_Attendance/spinnerSchedule.jsp")
    Call<List<Schedule>>spinnerSchedule();

    @GET("Admin_Attendance/showclss.jsp")
    Call<List<Student>>showclss(@Query("Clss")String Clss);

    @POST("Admin_Attendance/lectCount.jsp")
    @FormUrlEncoded
    Call<String>lectCount(@Field ("subject") String subject,
                          @Field("lect_date") String lect_date,
                          @Field("Clss") String Clss);

    @POST("Admin_Attendance/insertStud.jsp")
    @FormUrlEncoded
    Call<String>insertStud(@Field("Clss") String Clss,
                           @Field("Name") String Name,
                           @Field("RollNo") String RollNo,
                           @Field("Contact") String Contact);

    @POST("Admin_Attendance/updateStud.jsp")
    @FormUrlEncoded
    Call<String>updateStud(@Field("Contact") String Contact,
                           @Field("RollNo") String RollNo,
                           @Field("Name")String Name);


    @GET("Admin_Attendance/showStud.jsp")
    Call<List<Student>>showStud(@Query("RollNo")String RollNo);

    @POST("Admin_Attendance/insertSchedule.jsp")
    @FormUrlEncoded
    Call<String>insertSchedule(@Field("cl") String cl,
                               @Field("day") String day,
                               @Field("subject") String subject,
                               @Field("time_s") String time_s);

    @GET("Admin_Attendance/getSchedule.jsp")
    Call<List<Schedule>>getSchedule(@Query("Id") Integer Id);

    @GET("Admin_Attendance/deleteSchedule.jsp")
    Call<Integer>deleteSchedule(@Query("Id") Integer Id);

    @GET("Admin_Attendance/clearschedule.jsp")
    Call<String>clearSchedule();

    @GET("Admin_Attendance/clearAttendance.jsp")
    Call<String>clearAttendance();

    @POST("Admin_Attendance/teacher_changePass.jsp")
    @FormUrlEncoded
    Call<String>teacher_changePass(@Field("pass") String pass,
                           @Field("uname") String uname
                           );

    @POST("Admin_Attendance/takeAttendance.jsp")
    Call<String>takeAttendance(@Body List<Attendance> attendanceList);

}
