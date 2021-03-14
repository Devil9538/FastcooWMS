package com.fastcoo.fastcoowms.viewmodel;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcoo.fastcoowms.model.ApiData;
import com.fastcoo.fastcoowms.model.OnHold_Data;
import com.fastcoo.fastcoowms.model.OnHold_Status;
import com.fastcoo.fastcoowms.model.Schedule_Data;
import com.fastcoo.fastcoowms.model.Schedule_Status;
import com.fastcoo.fastcoowms.model.Service;
import com.fastcoo.fastcoowms.view.OnHold_Adaptor;
import com.fastcoo.fastcoowms.view.ScheduleAdaptor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnHoldViewModel extends ViewModel {

    final Calendar myCalendar = Calendar.getInstance();
    String fromdate="",todate="",sup_id="",awb_no;
    Activity activity;
    HashMap<String ,String > onHold_data;
    RecyclerView recyclerView;
    OnHold_Adaptor adaptor;
    List<OnHold_Data> onHold_statusList= new ArrayList<>();
    private ProgressDialog progressDialog;

    public void getContext(Context context){
        activity= (Activity) context;
    }



    public void From_Date(TextView from_date, ImageView from_back, ImageView from_forward){

        from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "dd-MM-yyyy"; // your format
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

                        from_date.setText(String.valueOf(sdf.format(myCalendar.getTime())));
                        fromdate= String.valueOf(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(activity, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                from_date.setText(fromdate);
                System.out.println("rdate is:"+from_date.getText().toString());
            }
        });

        from_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    cal.setTime(sdf.parse(from_date.getText().toString()));
                    cal.add(Calendar.DATE, -1);
                    String wantedDate = sdf.format(cal.getTime());
                    System.out.println("wantedDate is:"+wantedDate);
                    from_date.setText(wantedDate);

                }catch (Exception e)
                {

                }
            }
        });
        from_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    cal.setTime(sdf.parse(from_date.getText().toString()));
                    cal.add(Calendar.DATE, +1);
                    String wantedDate = sdf.format(cal.getTime());
                    System.out.println("wantedDate is:"+wantedDate);
                    from_date.setText(wantedDate);

                }catch (Exception e)
                {

                }
            }
        });
    }

    public void To_date(TextView to_date,ImageView to_back,ImageView to_forward){

        to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "dd-MM-yyyy"; // your format
                        SimpleDateFormat sdf1 = new SimpleDateFormat(myFormat, Locale.getDefault());

                        to_date.setText(String.valueOf(sdf1.format(myCalendar.getTime())));
                        todate= String.valueOf(sdf1.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(activity, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                to_date.setText(todate);
                System.out.println("rdate is:"+to_date.getText().toString());

            }
        });

        to_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    cal.setTime(sdf1.parse(to_date.getText().toString()));
                    cal.add(Calendar.DATE, -1);
                    String wantedDate = sdf1.format(cal.getTime());
                    System.out.println("wantedDate is:"+wantedDate);
                    to_date.setText(wantedDate);

                }catch (Exception e)
                {

                }
            }
        });
        to_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    cal.setTime(sdf1.parse(to_date.getText().toString()));
                    cal.add(Calendar.DATE, +1);
                    String wantedDate = sdf1.format(cal.getTime());
                    System.out.println("wantedDate is:"+wantedDate);
                    to_date.setText(wantedDate);

                }catch (Exception e)
                {

                }
            }
        });

    }

    public void getDetail(String awb,String id){
        awb_no=awb;
        sup_id=id;
        getOnHold_data();
    }

    public void getOnHold_data(){
        onHold_data= new HashMap<>();
        onHold_data.put("from_date",fromdate);
        onHold_data.put("to_date",todate);
        onHold_data.put("slip_no",awb_no);
        onHold_data.put("user_id",sup_id);
        progressDialog = ProgressDialog.show(activity, "Loading", "Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiData data= Service.getRetrofitInstance().create(ApiData.class);
        Call<OnHold_Status> call= data.onHold_wms(onHold_data);
        call.enqueue(new Callback<OnHold_Status>() {
            @Override
            public void onResponse(Call<OnHold_Status> call, Response<OnHold_Status> response) {
                response.body();

                if(response.body().getStatus().equals(1)){

                    OnHold_Data status= new OnHold_Data();
                    onHold_statusList.clear();
                    String Slip_no= response.body().getData().getAwb();
                    String schedule_date= response.body().getData().getScheduleDate();
                    String onHold= response.body().getData().getOnHold();
                    String area= response.body().getData().getDestination();
                    String origin= response.body().getData().getOrigin();
                    String onHold_Confirm= response.body().getData().getOnHoldConfirm();
                    status.setAwb(Slip_no);
                    status.setDestination(area);
                    status.setOnHold(onHold);
                    status.setOrigin(origin);
                    status.setOnHoldConfirm(onHold_Confirm);
                    status.setScheduleDate(schedule_date);
                    onHold_statusList.add(status);
                    adaptor= new OnHold_Adaptor(onHold_statusList,activity);
                    recyclerView.setLayoutManager(new GridLayoutManager(activity, 1, LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(adaptor);
                    adaptor.notifyDataSetChanged();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<OnHold_Status> call, Throwable t) {
                Toast.makeText(activity, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });



    }

    public void getRecycler(RecyclerView recycler){
        recyclerView= recycler;
    }

}
