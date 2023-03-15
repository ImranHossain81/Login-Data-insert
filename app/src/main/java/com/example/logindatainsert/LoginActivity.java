package com.example.logindatainsert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.logindatainsert.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    ApiInterface apiInterface;
    MySharedPreference sharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreference=MySharedPreference.getPreferences(LoginActivity.this);

        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ModelActivity modelActivity=new ModelActivity();
                modelActivity.setPhone(binding.userphone.getText().toString());
                modelActivity.setpassword(binding.editTextNumberPassword.getText().toString());


                apiInterface.login(modelActivity).enqueue(new Callback<ModelActivity>() {
                    @Override
                    public void onResponse(Call<ModelActivity> call, Response<ModelActivity> response) {


                        if (response.body().getResponse().equals("ok")) {



                            sharedPreference.setLogin("logged");
                            sharedPreference.setName(response.body().getName());
                            sharedPreference.setPhone(response.body().getPhone());

                            String getName=response.body().getName();
                            String getPhone=response.body().getPhone();

                            Intent intent=new Intent(LoginActivity.this,ProfileActivity.class);
                            intent.putExtra("name",getName);
                            intent.putExtra("phone",getPhone);
                            startActivity(intent);
                        }else {

                            Toast.makeText(LoginActivity.this, "Invalid phone or Password", Toast.LENGTH_SHORT).show();
                        }

                    }


                    @Override
                    public void onFailure(Call<ModelActivity> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, "No Internet connection", Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });
//
        binding.btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }
}