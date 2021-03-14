package com.fastcoo.fastcoowms.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.fastcoo.fastcoowms.BuildConfig;
import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.model.Login_Result;
import com.fastcoo.fastcoowms.viewmodel.LoginViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.edt_email)
    EditText email;

    @BindView(R.id.edt_password)
    EditText password;

    @BindView(R.id.btn_login)
    Button login;

    @BindView(R.id.tv_versioncode)
    TextView versioncode;

    private Login_Result result;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        int versionCode = BuildConfig.VERSION_CODE;
        viewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        viewModel.getContext(LoginActivity.this);
        viewModel.keepLogin();
        versioncode.setText("Version: "+String.valueOf(versionCode));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.Validation(email,password);

                viewModel.getToastObserver().observe(LoginActivity.this, message -> {
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                });
            }
        });

    }
}