package com.example.monitoryourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void button1(View v)
    {
        final Context context = this;
        Intent intent = new Intent(context, LoginPage.class);
        startActivity(intent);
    }

    public void button2(View v)
    {
        final Context context = this;
        Intent intent = new Intent(context, SignUpPage.class);
        startActivity(intent);
    }

}