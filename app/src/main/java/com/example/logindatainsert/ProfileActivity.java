package com.example.logindatainsert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.logindatainsert.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    MySharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        sharedPreference=MySharedPreference.getPreferences(this);

        if (sharedPreference.getLogin().equals("logged")){

            binding.pName.setText(sharedPreference.getName());
            binding.pPhone.setText(sharedPreference.getPhone());

        }
        else {

            binding.pName.setText(getIntent().getStringExtra("name"));
            binding.pPhone.setText(getIntent().getStringExtra("phone"));
        }

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreference.setLogin("none");
                startActivity(new Intent(ProfileActivity.this,SplashActivity.class));
            }
        });

    }

    private  void showDialog()
    {

        //dialog.show
        //getCurrent
        //sharedPreference to save date as a dialog date
    }


}