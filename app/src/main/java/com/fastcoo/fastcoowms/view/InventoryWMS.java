package com.fastcoo.fastcoowms.view;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.viewmodel.InventoryViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InventoryWMS extends AppCompatActivity {

    InventoryViewModel viewModel;
    @BindView(R.id.img_scan)
    ImageView scan;
    @BindView(R.id.edt_value_detail)
    EditText value_detail;
    @BindView(R.id.btn_shelve_submit)
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_w_m_s);
        ButterKnife.bind(this);
        viewModel= ViewModelProviders.of(this).get(InventoryViewModel.class);
        viewModel.onClick(scan,InventoryWMS.this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            if(resultCode== Activity.RESULT_OK && data!=null) {
                String value= data.getStringExtra("scanned_value");
//                Toast.makeText(this, "value: "+value, Toast.LENGTH_SHORT).show();
//                value_detail.setText(value);
                viewModel.showScannedDetails(submit,value_detail,value);


                }

            }
        }

}