package com.fastcoo.fastcoowms.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.fastcoo.fastcoowms.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentInfo extends AppCompatActivity {

    String shelve_no="";
    @BindView(R.id.tv_shelve_info)
    TextView shelve_info;
    @BindView(R.id.recycler_shipment)
    RecyclerView shipment_detail;
    @BindView(R.id.btn_shipment_submit)
    Button shipment_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_info);
        shelve_no= getIntent().getStringExtra("shelve_no");
        ButterKnife.bind(this);
        shelve_info.setText("Shelve: "+shelve_no);
    }
}