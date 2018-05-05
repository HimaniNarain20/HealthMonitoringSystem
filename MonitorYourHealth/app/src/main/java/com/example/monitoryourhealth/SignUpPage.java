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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpPage extends AppCompatActivity
{

   private  EditText et1,et2;
    String etusername,etpassword;
    Button bcontinuesignup;

    Intent intent;
    int flag=0;
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        et1 = (EditText) findViewById(R.id.newusername);
        et2 = (EditText) findViewById(R.id.newpassword);

    }
public void MoveToMainPage2(View view)
    {
        etusername = et1.getText().toString();
        etpassword = et2.getText().toString();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myref=database.getReference("ValidUsers/"+etusername);
        myref.child("Password").setValue(etpassword);
        Toast.makeText(this, "User Details saved in Firebase Cloud", Toast.LENGTH_SHORT).show();
        et1.setText("");
        et2.setText("");

        final Context context = this;
        Intent intent = new Intent(context, HomePage.class);
        startActivity(intent);
    }

    }


