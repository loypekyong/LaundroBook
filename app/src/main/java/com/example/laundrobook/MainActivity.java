package com.example.laundrobook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.Timestamp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //Test firebase code start
    TextView textViewMsg;
    final String node = "current_msg";
    DatabaseReference mRootDatabaseRef;
    DatabaseReference mNodeRef;

    //Test firebase code end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase test
        textViewMsg = findViewById(R.id.textViewMsg);
        mRootDatabaseRef = FirebaseDatabase.getInstance().getReference(); // root node
        mNodeRef = mRootDatabaseRef.child(node); // value of node key

        mNodeRef.addValueEventListener(new ValueEventListener() {

            // when firebase value change it runs the next method
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String change = snapshot.getValue(String.class);
                textViewMsg.setText(change);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Date d = new Date(System.currentTimeMillis());
//        Timestamp timestamp = new Timestamp(d);
        mNodeRef.setValue(d.toString());

        // end firebase test



    }
}