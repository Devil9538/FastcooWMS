package com.fastcoo.fastcoowms.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.fastcoo.fastcoowms.view.Scanner;
import com.fastcoo.fastcoowms.view.ShipmentInfo;

public class InventoryViewModel extends ViewModel {

    Activity activity;
    ImageView scan;

    public void onClick(ImageView scanner, Context context){

        activity= (Activity)context;
        scan= scanner;
        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanner= new Intent(activity, Scanner.class);
                activity.startActivityForResult(scanner,100);
            }
        });

    }

    public void showScannedDetails(Button click, EditText val,String scan_value){

        val.setText(scan_value);
        click.setVisibility(View.VISIBLE);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show();
                Intent go= new Intent(activity, ShipmentInfo.class);
                go.putExtra("shelve_no",scan_value);
                activity.startActivity(go);
            }
        });
    }
}
