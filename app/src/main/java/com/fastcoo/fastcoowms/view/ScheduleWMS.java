package com.fastcoo.fastcoowms.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.viewmodel.InventoryViewModel;
import com.fastcoo.fastcoowms.viewmodel.ScheduleViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleWMS extends AppCompatActivity {
    @BindView(R.id.edt_schedule_shelve)
    EditText shelve;
    @BindView(R.id.edt_schedule_awb)
    EditText awb;
    @BindView(R.id.from_date)
    TextView from_date;
    @BindView(R.id.to_date)
    TextView to_date;
    @BindView(R.id.backward_schedule)
    ImageView from_back;
    @BindView(R.id.forward_schedule)
    ImageView from_forward;
    @BindView(R.id.backward1_schedule)
    ImageView to_back;
    @BindView(R.id.forward1_schedule)
    ImageView to_forward;
    @BindView(R.id.btn_search_schedule)
    Button search;
    @BindView(R.id.recycler_schedule_detail)
    RecyclerView recyclerView;
    String id="";
    String slip_no;
    ScheduleViewModel scheduleViewModel;
    SharedPreferences schedule_preference;
    SharedPreferences.Editor schedule_editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_w_m_s);
        ButterKnife.bind(this);
        schedule_preference = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        schedule_editor = schedule_preference.edit();
        id= schedule_preference.getString("user_id",null);
        scheduleViewModel= ViewModelProviders.of(this).get(ScheduleViewModel.class);
        scheduleViewModel.From_Date(from_date,from_back,from_forward);
        scheduleViewModel.To_date(to_date,to_back,to_forward);
        scheduleViewModel.getContext(ScheduleWMS.this);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slip_no=awb.getText().toString();
                scheduleViewModel.getDetail(slip_no,id);
                scheduleViewModel.getRecycler(recyclerView);
            }
        });


    }
}