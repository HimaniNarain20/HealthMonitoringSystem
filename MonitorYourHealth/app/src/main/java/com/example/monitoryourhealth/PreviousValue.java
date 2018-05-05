package com.example.monitoryourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class PreviousValue extends AppCompatActivity {

    private Button finalprevious;
    private DatabaseReference mdatabase;
    private EditText et1;
    String mNameField;
//    private EditText mAgeField;
//    private EditText mGenderField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_value);



      finalprevious=(Button) findViewById(R.id.finalprevious);
//
//
        et1=(EditText) findViewById(R.id.name);

    }

    public void MoveToNextPreviousPage(View v) {
        mNameField=et1.getText().toString();
        final Context context = this;
        Intent intent = new Intent(context, NextPreviousPage.class);
        intent.putExtra("Name",mNameField);
        startActivity(intent);
    }
}
