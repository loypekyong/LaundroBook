package com.example.laundrobook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

    ImageView charaImage;
    Button loginButton;

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

        charaImage = findViewById(R.id.charaImage);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                View TimingPanel = getLayoutInflater().inflate(R.layout.activity_timing_panel, null);
                setContentView(TimingPanel);
            /*    View FacilitiesPanel = getLayoutInflater().inflate(R.layout.activity_facilities_panel, null);
                setContentView(FacilitiesPanel);*/
            /*    // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.activity_pop_up, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window token
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);*/

            }
        });



    }
}