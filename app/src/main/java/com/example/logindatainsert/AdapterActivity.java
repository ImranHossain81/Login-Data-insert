package com.example.logindatainsert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.Myholder> {

    ArrayList<ModelActivity> modelActivities;
    Context context;

    public AdapterActivity(ArrayList<ModelActivity> modelActivities, Context context) {

        this.modelActivities = modelActivities;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterActivity.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterActivity.Myholder holder, int position) {

        holder.tname.setText(modelActivities.get(position).getName());
        holder.tphone.setText(modelActivities.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return modelActivities.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {

        TextView tname, tphone;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            tname = itemView.findViewById(R.id.tvname);
            tphone = itemView.findViewById(R.id.tvphone);
        }
    }

    public void searchPerson(ArrayList<ModelActivity> list) {


        modelActivities = list;
        notifyDataSetChanged();
    }
}
