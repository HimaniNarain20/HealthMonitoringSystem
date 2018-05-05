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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class LoginPage extends AppCompatActivity
{

    EditText etusername, etpassword;
    Button bcontinuelogin;
    FirebaseAuth firebaseAuth;
    Intent intent;
    int flag = 0;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        etusername = (EditText) (findViewById(R.id.username));
        etpassword = (EditText) (findViewById(R.id.password));

    }
    public void loginClick(View v)
    {
        user = etusername.getText().toString();
        pass = etpassword.getText().toString();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myref=database.getReference().child("ValidUsers");
        myref.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Map<String,Map<String,String>> map=(Map)dataSnapshot.getValue();
                Set<String> keys=map.keySet();
                Iterator<String> itr=keys.iterator();
                while(itr.hasNext())
                {
                    String id = itr.next();
                    Map<String,String> childMap = map.get(id);
                    String pass2 = childMap.get("Password");
//                    Toast.makeText(LoginPage.this, id, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(LoginPage.this, pass2, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(LoginPage.this, user, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(LoginPage.this, pass, Toast.LENGTH_SHORT).show();
                    if (user.equals(id) &&  pass.equals(pass2))
                    {
                        Toast.makeText(LoginPage.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        flag = 1;
                        break;
                    }
                }
                if(flag==0)
                {
                    Toast.makeText(LoginPage.this, "Incorrect username/password", Toast.LENGTH_SHORT).show();
                    etusername.setText("");
                    etpassword.setText("");
                }
                else
                {
                    Intent i = new Intent(LoginPage.this,Check.class);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(LoginPage.this, "Error:"+databaseError, Toast.LENGTH_SHORT).show();

            }
        });

    }
}



