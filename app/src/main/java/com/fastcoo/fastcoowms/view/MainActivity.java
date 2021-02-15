package com.fastcoo.fastcoowms.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.model.Login_Result;
import com.fastcoo.fastcoowms.model.Loginmodel;
import com.fastcoo.fastcoowms.viewmodel.LoginViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Binds;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edt_email)
    EditText email;

    @BindView(R.id.edt_password)
    EditText password;

    @BindView(R.id.btn_login)
    Button login;

    private Login_Result result;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        viewModel.getContext(MainActivity.this);
        viewModel.keepLogin();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.Validation(email,password);

                viewModel.getToastObserver().observe(MainActivity.this, message -> {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                });
            }
        });

    }
}