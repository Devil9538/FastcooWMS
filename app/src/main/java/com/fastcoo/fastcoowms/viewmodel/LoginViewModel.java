package com.fastcoo.fastcoowms.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fastcoo.fastcoowms.model.ApiData;
import com.fastcoo.fastcoowms.model.Loginmodel;
import com.fastcoo.fastcoowms.model.Service;
import com.fastcoo.fastcoowms.view.DashBoard;
import com.fastcoo.fastcoowms.view.MainActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
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


    public void getLogin(String email,String password){

        ApiData data= Service.getRetrofitInstance().create(ApiData.class);
        Call<Loginmodel> call=data.login(email,password);
        call.enqueue(new Callback<Loginmodel>() {
            @Override
            public void onResponse(Call<Loginmodel> call, Response<Loginmodel> response) {
                response.body();
                if(response.body().getStatus().equals(200)){
                    String user_id= response.body().getResult().getUserId();
                    String username= response.body().getResult().getUsername();
                    String mobile_no= response.body().getResult().getMobileNo();
                    login_editor.putString("user_id",user_id);
                    login_editor.putString("username",username);
                    login_editor.putString("mobile_no",mobile_no);
                    login_editor.commit();
                Intent go = new Intent(context1, DashBoard.class);
                context1.startActivity(go);


                    Toast.makeText(context1, "login success", Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<Loginmodel> call, Throwable t) {
                toastMessageObserver.setValue(t.getLocalizedMessage());

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
}
