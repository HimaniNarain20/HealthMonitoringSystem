package com.example.monitoryourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainPage extends AppCompatActivity {
//    private Button normal;
//    private Button previous;
//    private Button measure;
//    private Button logout;

//    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
//        normal=(Button) findViewById(R.id.normal);
//        previous=(Button) findViewById(R.id.previous);
//        measure=(Button) findViewById(R.id.measure);
//        logout=(Button) findViewById(R.id.logout);
//
//        mdatabase= FirebaseDatabase.getInstance().getReference();
//
//        normal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }


    public void MoveToHomePage(View v) {
        final Context context = this;
        Intent intent = new Intent(context, HomePage.class);

        startActivity(intent);
    }

    public void MoveToCurrentValues(View v)
    {
        final Context context = this;
        Intent intent = new Intent(context, CurrentValue.class);

        startActivity(intent);
    }
    public void MoveToNormalValues(View v)
    {
        final Context context = this;
        Intent intent = new Intent(context, NormalValue.class);

        startActivity(intent);
    }
    public void MoveToPreviousMeasurements(View v)
    {
        final Context context = this;
        Intent intent = new Intent(context, PreviousValue.class);

        startActivity(intent);
    }

    }


