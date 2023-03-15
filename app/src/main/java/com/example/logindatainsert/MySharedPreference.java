package com.example.logindatainsert;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor ;
    private static MySharedPreference mysharedPreferance=null;


    private  MySharedPreference(Context context)
    {
        sharedPreferences = context.getSharedPreferences("shared",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public static synchronized MySharedPreference getPreferences(Context context)
    {

        if(mysharedPreferance==null) {
            mysharedPreferance = new MySharedPreference(context);
        }

        return mysharedPreferance;
    }


    public void setLogin(String user)
    {
        editor.putString("login",user);
        editor.apply();
    }

    public String getLogin()
    {
        return sharedPreferences.getString("login","none");
    }



    public void setName(String user)
    {
        editor.putString("name",user);
        editor.apply();
    }

    public String getName()
    {
        return sharedPreferences.getString("name","none");
    }


    public void setPhone(String user)
    {
        editor.putString("phone",user);
        editor.apply();
    }

    public String getPhone()
    {
        return sharedPreferences.getString("phone","none");
    }



}
