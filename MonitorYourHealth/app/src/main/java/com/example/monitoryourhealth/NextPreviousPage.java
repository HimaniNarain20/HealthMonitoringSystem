package com.example.monitoryourhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NextPreviousPage extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private TextView mNameView;
    private TextView mAgeView;
    private TextView mGenderView;
    private TextView mLastValueView;
    String n,age,gender,previous;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_previous_page);
        Intent box = getIntent();
        Bundle b = box.getExtras();
        n = b.getString("Name");

        mDatabase= FirebaseDatabase.getInstance().getReference().child("UserInfo");
        mDatabase.addValueEventListener(new ValueEventListener()
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

                    if (n.equals(id))
                    {
                        Toast.makeText(NextPreviousPage.this, "Data Found", Toast.LENGTH_SHORT).show();
                        age = childMap.get("Age");
                        gender = childMap.get("Gender");
                        previous=childMap.get("PreviousValue");
                        flag = 1;
                        break;
                    }
                }
                if(flag==0)
                {
                    Toast.makeText(NextPreviousPage.this, "Data Not Found", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    mNameView=(TextView) findViewById(R.id.name_view);
                    mAgeView=(TextView) findViewById(R.id.age_view);
                    mGenderView=(TextView) findViewById(R.id.gender_view);
                    mLastValueView=(TextView) findViewById(R.id.lastvalue);
                    mNameView.append(n);
                    mAgeView.append(age);
                    mGenderView.append(gender);
                    mLastValueView.append(previous);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(NextPreviousPage.this, "Error:"+databaseError, Toast.LENGTH_SHORT).show();

            }
        });

    }
}



