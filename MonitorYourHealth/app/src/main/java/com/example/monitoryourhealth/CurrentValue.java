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

public class CurrentValue extends AppCompatActivity {

    private Button finalmeasure;
    private DatabaseReference mdatabase;
    String mNameField;
    private EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_value);
        finalmeasure=(Button) findViewById(R.id.finalmeasure);
       et1=(EditText) findViewById(R.id.name);

   }

    public void MoveToNextCurrentPage(View v) {
        mNameField=et1.getText().toString();

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //DatabaseReference myref=database.getReference("UserInfo/"+mNameField);
        final Context context = this;
        Intent intent = new Intent(context, NextCurrentPage.class);
        intent.putExtra("Name",mNameField);
        startActivity(intent);
    }
}
