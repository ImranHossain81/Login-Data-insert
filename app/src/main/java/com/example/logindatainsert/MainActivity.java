package com.example.logindatainsert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.logindatainsert.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit retrofit = ApiClient.getClient();
                apiInterface = retrofit.create(ApiInterface.class);

                ModelActivity modelActivity=new ModelActivity();
                modelActivity.setName(binding.name.getText().toString());
                modelActivity.setPhone(binding.phone.getText().toString());
                modelActivity.setpassword(binding.password.getText().toString());


                apiInterface.insertActivity(modelActivity).enqueue(new Callback<ModelActivity>() {
                    @Override
                    public void onResponse(Call<ModelActivity> call, Response<ModelActivity> response) {

                        Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<ModelActivity> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });



        binding.showListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }


}