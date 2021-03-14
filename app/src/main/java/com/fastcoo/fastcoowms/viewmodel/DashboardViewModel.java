package com.fastcoo.fastcoowms.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModel;

import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.view.InBoundWMS;
import com.fastcoo.fastcoowms.view.InventoryWMS;
import com.fastcoo.fastcoowms.view.LoginActivity;
import com.fastcoo.fastcoowms.view.OnHoldWMS;
import com.fastcoo.fastcoowms.view.ScheduleWMS;
import com.scwang.wave.MultiWaveHeader;

import static android.content.Context.MODE_PRIVATE;

public class DashboardViewModel extends ViewModel {

    Context context1;
    SharedPreferences dashboard_preference;
    SharedPreferences.Editor dashboard_editor;
    String user_id="";

    public void wave(MultiWaveHeader multiWaveHeader){
        dashboard_preference =context1.getSharedPreferences("MyPref",MODE_PRIVATE);
        dashboard_editor= dashboard_preference.edit();
        user_id= dashboard_preference.getString("user_id",null);
        Log.d("id",user_id);
        multiWaveHeader.setVelocity(1);
        multiWaveHeader.setProgress(1);
        multiWaveHeader.isRunning();
        multiWaveHeader.setGradientAngle(45);
        multiWaveHeader.setWaveHeight(45);
        multiWaveHeader.setStartColor(context1.getResources().getColor(R.color.colorPrimary));
        multiWaveHeader.setCloseColor(context1.getResources().getColor(R.color.colorPrimaryDark));
    }

    public void getContext(Context context){
        context1= context;
    }

    public void logout(LinearLayout logout){
        Activity activity = (Activity)context1;
        dashboard_editor.clear();
        dashboard_editor.commit();
        Intent logout_1= new Intent(context1, LoginActivity.class);
        activity.startActivity(logout_1);
        activity.finish();
    }

    public void inventoryWMS(LinearLayout inventory){
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity)context1;
                Intent inventory= new Intent(activity, InventoryWMS.class);
                activity.startActivity(inventory);

            }
        });

    }
    public void onHoldWMS(LinearLayout onhold){
        onhold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity)context1;
                Intent onhold= new Intent(activity, OnHoldWMS.class);
                activity.startActivity(onhold);
            }
        });
    }

    public void ScheduleWMS(LinearLayout schedule){
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity)context1;
                Intent schedule= new Intent(activity, ScheduleWMS.class);
                activity.startActivity(schedule);
            }
        });
    }

    public void InBound(LinearLayout inbound){
        inbound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity)context1;
                Intent inbound= new Intent(activity, InBoundWMS.class);
                activity.startActivity(inbound);
            }
        });
    }
}
