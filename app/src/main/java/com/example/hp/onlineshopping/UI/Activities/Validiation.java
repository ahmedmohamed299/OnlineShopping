package com.example.hp.onlineshopping.UI.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.onlineshopping.Model.APIs;
import com.example.hp.onlineshopping.Model.DataModel.GetActivate;
import com.example.hp.onlineshopping.Model.RetrofitAPI;
import com.example.hp.onlineshopping.R;
import com.example.hp.onlineshopping.UI.Base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Validiation extends BaseActivity {

    TextView activationCode,Skip;
    Button Login;
    RetrofitAPI retrofitAPI;
    String Token,activation_code;
    String Lang="en";
    APIs apIs;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validiation);
        activationCode=findViewById(R.id.activationCode);
        Login=findViewById(R.id.Login);
        Skip=findViewById(R.id.Skip);
        activation_code=activationCode.getText().toString();
        sharedPreferences = getSharedPreferences("appSharedPre", MODE_PRIVATE);
        apIs = RetrofitAPI.getApiService();
        Token=sharedPreferences.getString("token","");


    }

    public void Login(View view) {

        apIs.getactivate(Token,Lang,activation_code).enqueue(new Callback<GetActivate>() {
            @Override
            public void onResponse(Call<GetActivate> call, Response<GetActivate> response) {

            }

            @Override
            public void onFailure(Call<GetActivate> call, Throwable t) {

            }
        });
    }

    public void Skip(View view) {
        Intent i=new Intent(this,Home.class);
        startActivity(i);
    }
}
