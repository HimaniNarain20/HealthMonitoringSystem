package com.example.monitoryourhealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CurrentValue2 extends AppCompatActivity {
    private Button finalmeasure;
    private DatabaseReference mdatabase;
    String mNameField;
 String mAgeField;
    String mGenderField;
    String mContactField;
    private EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_value2);
        finalmeasure=(Button) findViewById(R.id.finalmeasure);


        et1=(EditText) findViewById(R.id.name);
        et2=(EditText) findViewById(R.id.age);
       et3=(EditText) findViewById(R.id.gender);
        et4=(EditText) findViewById(R.id.phone);
    }
    public void MoveToNextCurrentPage2(View v) {
        mNameField=et1.getText().toString();
        mAgeField=et2.getText().toString();
        mGenderField=et3.getText().toString();
        mContactField=et4.getText().toString();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myref=database.getReference("UserInfo/"+mNameField);
        myref.child("Age").setValue(mAgeField);
        myref.child("Gender").setValue(mGenderField);
        myref.child("PatientContact").setValue(mContactField);
        Toast.makeText(this, "User Information saved in Firebase Cloud", Toast.LENGTH_SHORT).show();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        final Context context = this;
        Intent intent = new Intent(context, NextCurrentPage2.class);
        intent.putExtra("Name2",mNameField);
        startActivity(intent);
    }
}
