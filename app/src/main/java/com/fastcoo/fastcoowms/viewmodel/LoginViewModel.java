package com.fastcoo.fastcoowms.viewmodel;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fastcoo.fastcoowms.model.ApiData;
import com.fastcoo.fastcoowms.model.Loginmodel;
import com.fastcoo.fastcoowms.model.Service;
import com.fastcoo.fastcoowms.view.DashBoard;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<Loginmodel> login_data= new MutableLiveData<Loginmodel>();
    private MutableLiveData<String> toastMessageObserver = new MutableLiveData();
    private CompositeDisposable disposable= new CompositeDisposable();
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    SharedPreferences login_preference;
    SharedPreferences.Editor login_editor;
    Context context1;
    private ProgressDialog progressDialog;
    boolean connected = false;
    HashMap<String,String> login;


    public void getLogin(String email,String password){
        internetIsConnected();
        login= new HashMap<>();
        login.put("username",email);
        login.put("password",password);
        progressDialog = ProgressDialog.show(context1, "Login", "Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        ApiData data= Service.getRetrofitInstance().create(ApiData.class);
        Call<Loginmodel> call=data.login(login);
        call.enqueue(new Callback<Loginmodel>() {
            @Override
            public void onResponse(Call<Loginmodel> call, Response<Loginmodel> response) {
                response.body();
                if(response.body().getStatus().equals(1)){
                    for(int i=0;i<response.body().getData().size();i++){
                        String user_id= response.body().getData().get(i).getId();
                        String username= response.body().getData().get(i).getName();
                        String email= response.body().getData().get(i).getEmail();
                        login_editor.putString("user_id",user_id);
                        login_editor.putString("username",username);
                        login_editor.putString("mobile_no",email);
                        login_editor.commit();
                    }
                Intent go = new Intent(context1, DashBoard.class);
                context1.startActivity(go);
                progressDialog.dismiss();


                    Toast.makeText(context1, "login success", Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<Loginmodel> call, Throwable t) {
//                toastMessageObserver.setValue(t.getLocalizedMessage());
                progressDialog.dismiss();

            }
        });
    }



    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    public LiveData<String> getToastObserver(){
        return toastMessageObserver;
    }

    public void getContext(Context context){
       context1= context;
    }

    public void Validation(EditText email, EditText password){
        String email_data= email.getText().toString();
        String password_data= password.getText().toString();

        if(!(email.getText().toString().matches(emailPattern))){
            email.setError("enter valid email");
        }else  if( password.getText().toString().equals("")){

            password.setError("Password can not be empty");
        }else {
            getLogin(email_data,password_data);
        }



    }

    public void keepLogin(){
        login_preference= context1.getSharedPreferences("MyPref",MODE_PRIVATE);
        login_editor= login_preference.edit();
        String value = login_preference.getString("user_id",null);
        if (value == null) {
            // the key does not exist
        } else {
            Intent i = new Intent(context1, DashBoard.class);
            context1.startActivity(i);

        }
    }

    public Boolean internetIsConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)context1.getSystemService(context1.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            return connected;
        }
        else
            connected = false;
        Toast.makeText(context1, "Check Internet Connection", Toast.LENGTH_SHORT).show();
        return connected;
    }
}
