package com.example.monitoryourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NormalValue2 extends AppCompatActivity {
    private Button finalnormal;
    private DatabaseReference mdatabase;
    String mNameField;

    private EditText et1,et2,et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_value2);


       finalnormal=(Button) findViewById(R.id.finalnormal);


        et1=(EditText) findViewById(R.id.name);

    }
    public void MoveToNextNormalPage2(View v) {
        mNameField=et1.getText().toString();

        final Context context = this;
        Intent intent = new Intent(context, NextNormalPage2.class);
        intent.putExtra("Name2",mNameField);
        startActivity(intent);
    }
}
