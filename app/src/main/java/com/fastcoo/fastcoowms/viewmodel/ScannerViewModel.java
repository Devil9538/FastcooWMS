package com.fastcoo.fastcoowms.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.fastcoo.fastcoowms.view.InventoryWMS;
import com.google.zxing.Result;

public class ScannerViewModel extends ViewModel {

    Activity activity;
    private CodeScanner mCodeScanner;


    public void Scanner(CodeScannerView scan, Context context){
        activity=(Activity)context;
        mCodeScanner= new CodeScanner(activity,scan);
        mCodeScanner.startPreview();
        try {
            mCodeScanner.startPreview();
            mCodeScanner.setDecodeCallback(new DecodeCallback() {
                public void onDecoded(@NonNull final Result result) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String value= result.getText().toString();
                            Intent takeResult= new Intent(activity, InventoryWMS.class);
                            takeResult.putExtra("scanned_value",""+value);
                            activity.setResult(Activity.RESULT_OK,takeResult);
                            activity.finish();

                        }

                    });
                }
            });
        }catch (Exception e){

        }



    }

}
