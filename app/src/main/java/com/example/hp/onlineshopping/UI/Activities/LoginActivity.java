package com.example.hp.onlineshopping.UI.Activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hp.onlineshopping.Model.APIs;
import com.example.hp.onlineshopping.Model.DataModel.GetRegister;
import com.example.hp.onlineshopping.Model.RetrofitAPI;
import com.example.hp.onlineshopping.R;
import com.example.hp.onlineshopping.UI.Base.BaseActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends BaseActivity {

    EditText PhoneNumber,FirstName,LastName;
    TextView Skip;
    Button Login,loginbutton;
    APIs apIs;
//    HashMap map=new HashMap();
    RetrofitAPI retrofitAPI;
    String Token,activation_code;
    String Lang="en";
    String mobile_number,name;
    private static final String EMAIL = "email";
    CallbackManager callbackManager;



    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        PhoneNumber=findViewById(R.id.PhoneNumber);
        FirstName=findViewById(R.id.FirstName);
        LastName=findViewById(R.id.LastName);
        Login=findViewById(R.id.Login);
        Skip=findViewById(R.id.Skip);
        sharedPreferences = getSharedPreferences("appSharedPre", MODE_PRIVATE);
        apIs=retrofitAPI.getApiService();
        aasdasd();
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        // Build a GoogleSignInClient with the options specified by gso.
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//
//        private void signIn() {
//            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//            startActivityForResult(signInIntent, RC_SIGN_IN);
//        }



        final Intent intent=new Intent(this,Validiation.class);
         callbackManager = CallbackManager.Factory.create();

        loginbutton = (LoginButton) findViewById(R.id.login_button);
        ((LoginButton) loginbutton).setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
         ((LoginButton) loginbutton).registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }

    private void aasdasd() {

        try{
            PackageInfo info= getPackageManager().getPackageInfo("com.example.hp.onlineshopping",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature:info.signatures){
                MessageDigest messageDigest=MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.d("KEYHAsh", Base64.encodeToString(messageDigest.digest(),Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void Skip(View view) {
        Intent i=new Intent(this,Home.class);
        startActivity(i);
    }

    public void Login(View view) {
//        map.put("mobile_number",PhoneNumber.getText().toString());
//        map.put("name",FirstName.getText().toString()+LastName.getText().toString());
//        map.put("device_token","test");

        name=FirstName.getText().toString()+LastName.getText().toString();
        mobile_number=PhoneNumber.getText().toString();
        Log.e("name","t"+name);
        apIs.getRegister("01156616441","test",
                "ahmed").enqueue(new Callback<GetRegister>() {
            @Override
            public void onResponse(Call<GetRegister> call, Response<GetRegister> response) {
                Log.e("code",response.code()+"");
                Log.e("status",response.body().status+"");
                Token=response.body().data.getToken();

                editor = sharedPreferences.edit();
                editor.putString("token", Token);
                editor.apply();

                Intent intent=new Intent(LoginActivity.this,Validiation.class);

                startActivity(intent);
            }

            @Override
            public void onFailure(Call<GetRegister> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
