package com.example.logindatainsert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.logindatainsert.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListActivity extends AppCompatActivity {

    AdapterActivity adapterActivity;
    ArrayList<ModelActivity>modelActivities=new ArrayList<>();

    ApiInterface apiInterface;
    private ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        adapterActivity=new AdapterActivity(modelActivities,this);
        binding.recyclerPerson.setLayoutManager(new LinearLayoutManager(this));


        //binding.recyclerPerson.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));


        getdata();

        binding.searchPerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                ArrayList<ModelActivity>searchArrayList=new ArrayList<>();
                for(ModelActivity item: modelActivities)

                {
                    if (item.getName().toLowerCase().contains(editable.toString().toLowerCase())
                            || item.getPhone().toLowerCase().contains(editable.toString().toLowerCase())
                    )
                    {
                        searchArrayList.add(item);
                    }
                }

                adapterActivity.searchPerson(searchArrayList);
            }
        });
    }

    private void getdata()
    {
        Retrofit retrofit= ApiClient.getClient();
        apiInterface=retrofit.create(ApiInterface.class);

        apiInterface.getAllData().enqueue(new Callback<java.util.List<ModelActivity>>() {
            @Override
            public void onResponse(Call<java.util.List<ModelActivity>> call, Response<java.util.List<ModelActivity>> response) {

                modelActivities.addAll(response.body());
                binding.recyclerPerson.setAdapter(adapterActivity);
                adapterActivity.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<java.util.List<ModelActivity>> call, Throwable t) {

              Toast.makeText(ListActivity.this, "something wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

}