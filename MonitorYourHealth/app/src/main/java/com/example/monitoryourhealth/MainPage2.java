package com.example.monitoryourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page2);
    }
    public void MoveToCurrentValues2(View v)
    {
        final Context context = this;
        Intent intent = new Intent(context, CurrentValue2.class);

        startActivity(intent);
    }
    public void MoveToNormalValues2(View v)
    {
        final Context context = this;
        Intent intent = new Intent(context, NormalValue2.class);

        startActivity(intent);
    }
    public void MoveToHomePage2(View v) {
        final Context context = this;
        Intent intent = new Intent(context, HomePage.class);

        startActivity(intent);
    }

}
