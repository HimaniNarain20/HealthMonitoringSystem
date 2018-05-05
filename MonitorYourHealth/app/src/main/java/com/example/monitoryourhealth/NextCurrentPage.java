package com.example.monitoryourhealth;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NextCurrentPage extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private TextView mNameView;
    private TextView mAgeView;
    private TextView mGenderView;
    private TextView mPresentValueView;
    String n,n2,age,gender,phone,current,normal,previous;
    int flag=0;
    private ImageButton calling;

//    private ListView mUserList;
//    private ArrayList<String> mUsernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_current_page);
        calling=(ImageButton) findViewById(R.id.imageButton5);
        Intent box = getIntent();
        Bundle b = box.getExtras();
        n = b.getString("Name");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("UserInfo");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Map<String, String>> map = (Map) dataSnapshot.getValue();
                Set<String> keys = map.keySet();
                Iterator<String> itr = keys.iterator();
                while (itr.hasNext()) {
                    String id = itr.next();
                    Map<String, String> childMap = map.get(id);

                    if (n.equals(id)) {
                        Toast.makeText(NextCurrentPage.this, "Data Found", Toast.LENGTH_SHORT).show();
                        age = childMap.get("Age");
                        gender = childMap.get("Gender");
                        current=childMap.get("CurrentValue");
                        normal=childMap.get("NormalValue");
                        previous=childMap.get("PreviousValue");
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    Toast.makeText(NextCurrentPage.this, "Data Not Found", Toast.LENGTH_SHORT).show();

                } else {
                    mNameView = (TextView) findViewById(R.id.name_view);
                    mAgeView = (TextView) findViewById(R.id.age_view);
                    mGenderView = (TextView) findViewById(R.id.gender_view);
                    mPresentValueView = (TextView) findViewById(R.id.presentvalue);
                    mNameView.append(n);
                    mAgeView.append(age);
                    mGenderView.append(gender);
                    mPresentValueView.append(current);
                    if(current.equals(normal))
                    {
                        Toast.makeText(NextCurrentPage.this, "Your Values Are Normal!!!Relaxxx", Toast.LENGTH_SHORT).show();
                        calling.setEnabled(false);
                    }
                    else
                    {
                        Toast.makeText(NextCurrentPage.this, "Your Values Are Not Normal", Toast.LENGTH_SHORT).show();
                        calling.setEnabled(true);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(NextCurrentPage.this, "Error:" + databaseError, Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void call(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("UserInfo");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Map<String, Map<String, String>> map = (Map) dataSnapshot.getValue();
                Set<String> keys = map.keySet();
                Iterator<String> itr = keys.iterator();
                while (itr.hasNext())
                {
                    String id = itr.next();
                    Map<String, String> childMap = map.get(id);
                    phone = childMap.get("PatientContact");
                    if (n.equals(id))
                    {

                    }
                    else
                    {
                        continue;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(NextCurrentPage.this, "Error:" + databaseError, Toast.LENGTH_SHORT).show();

            }
        });
        Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8755138397"));
        startActivity(i);

    }


}











