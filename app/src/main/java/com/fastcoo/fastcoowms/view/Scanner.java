package com.fastcoo.fastcoowms.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.budiyev.android.codescanner.CodeScannerView;
import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.viewmodel.ScannerViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Scanner extends AppCompatActivity {

    @BindView(R.id.scanner_view)
    CodeScannerView scannerView;

    ScannerViewModel scannerViewModel;
    private static final int MY_CAMERA_REQUEST_CODE = 100;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        ButterKnife.bind(this);
        scannerViewModel= ViewModelProviders.of(this).get(ScannerViewModel.class);

        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }else {
            scannerViewModel.Scanner(scannerView,Scanner.this);
        }
    }


}