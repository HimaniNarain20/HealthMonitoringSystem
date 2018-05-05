package com.example.monitoryourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
    }

    public void MoveToMainPage(View v) {
        final Context context = this;
        Intent intent = new Intent(context, MainPage.class);

        startActivity(intent);
    }
    public void MoveToMainPage2(View v) {
        final Context context = this;
        Intent intent = new Intent(context, MainPage2.class);

        startActivity(intent);
    }
}
