package com.fastcoo.fastcoowms.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.viewmodel.DashboardViewModel;
import com.fastcoo.fastcoowms.viewmodel.LoginViewModel;
import com.scwang.wave.MultiWaveHeader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoard extends AppCompatActivity {

    @BindView(R.id.waveHeader)
    MultiWaveHeader waveHeader;
    @BindView(R.id.linear_inventory)
    LinearLayout inventory;
    @BindView(R.id.linear_onhold)
    LinearLayout onhold;
    @BindView(R.id.linear_schedule)
    LinearLayout schedule;
    @BindView(R.id.linear_inbound)
    LinearLayout inbound;
    @BindView(R.id.linear_logout)
    LinearLayout logout;





    private DashboardViewModel dashboardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
        dashboardViewModel= ViewModelProviders.of(this).get(DashboardViewModel.class);
        dashboardViewModel.getContext(DashBoard.this);
        dashboardViewModel.wave(waveHeader);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dashboardViewModel.logout(logout);
                finish();
            }
        });

        dashboardViewModel.inventoryWMS(inventory);
        dashboardViewModel.onHoldWMS(onhold);
        dashboardViewModel.ScheduleWMS(schedule);
        dashboardViewModel.InBound(inbound);

    }



}