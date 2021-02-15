package com.fastcoo.fastcoowms.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModel;

import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.view.DashBoard;
import com.fastcoo.fastcoowms.view.MainActivity;
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

        dashboard_editor.clear();
        dashboard_editor.commit();
        Intent logout_1= new Intent(context1, MainActivity.class);
        context1.startActivity(logout_1);
    }
}
