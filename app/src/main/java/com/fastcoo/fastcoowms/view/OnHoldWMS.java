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
import com.fastcoo.fastcoowms.viewmodel.OnHoldViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnHoldWMS extends AppCompatActivity {

    
    @BindView(R.id.edt_search_onHold_shipment)
    EditText awb;
    @BindView(R.id.onhold_date)
    TextView from_date;
    @BindView(R.id.onhold_date1)
    TextView to_date;
    @BindView(R.id.onhold_backward)
    ImageView from_back;
    @BindView(R.id.onhold_forward)
    ImageView from_forward;
    @BindView(R.id.onhold_backward1)
    ImageView to_back;
    @BindView(R.id.onhold_forward1)
    ImageView to_forward;
    @BindView(R.id.btn_search_ship)
    Button search;
    @BindView(R.id.recycler_onhold_detail)
    RecyclerView recyclerView;
    OnHoldViewModel onHoldViewModel;
    String id="";
    String slip_no;
    SharedPreferences onHold_preference;
    SharedPreferences.Editor onHold_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onhold_w_m_s);
        ButterKnife.bind(this);
        onHoldViewModel= ViewModelProviders.of(this).get(OnHoldViewModel.class);
        onHold_preference = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        onHold_editor = onHold_preference.edit();
        id= onHold_preference.getString("user_id",null);
        onHoldViewModel.From_Date(from_date,from_back,from_forward);
        onHoldViewModel.To_date(to_date,to_back,to_forward);
        onHoldViewModel.getContext(OnHoldWMS.this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slip_no=awb.getText().toString();
                onHoldViewModel.getDetail(slip_no,id);
                onHoldViewModel.getRecycler(recyclerView);
            }
        });
    }
}