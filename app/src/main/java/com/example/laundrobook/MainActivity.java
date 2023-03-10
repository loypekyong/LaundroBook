package com.example.laundrobook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    TextView textViewMsg; // text view to display message
    DatabaseReference mRootDatabaseRef; // root node

    ImageView charaImage; // character image
    Button loginButton; // login button
    Button registerButton; // register button

    EditText editTextUsername; // username

    EditText editTextPassword; // password
    String username; // username
    String password; // password

    DatabaseReference mAccountRef; // reference to the account node
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by id
        textViewMsg = findViewById(R.id.textViewMsg);
        charaImage = findViewById(R.id.charaImage);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        mRootDatabaseRef = FirebaseDatabase.getInstance().getReference(); // root node
        mAccountRef = mRootDatabaseRef.child("Accounts"); // reference to the account node

        // Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();

                mAccountRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Account account = dataSnapshot.getValue(Account.class);
                            if (account.getPasswordHash().equals(password)) {
                                textViewMsg.setText("Login successful");
                                View TimingPanel = getLayoutInflater().inflate(R.layout.activity_timing_panel, null);
                                setContentView(TimingPanel);
                            } else {
                                textViewMsg.setText("Wrong password");
                            }
                        } else {
                            textViewMsg.setText("Username does not exist");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        // Register button
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                mAccountRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            textViewMsg.setText("Username already exists");
                        } else {
                            Account account = new Account(username, password);
                            mAccountRef.child(username).setValue(account);
                            textViewMsg.setText("Account created");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

//            /*    View FacilitiesPanel = getLayoutInflater().inflate(R.layout.activity_facilities_panel, null);
//                setContentView(FacilitiesPanel);*/
//            /*    // inflate the layout of the popup window
//                LayoutInflater inflater = (LayoutInflater)
//                        getSystemService(LAYOUT_INFLATER_SERVICE);
//                View popupView = inflater.inflate(R.layout.activity_pop_up, null);
//
//                // create the popup window
//                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
//                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
//                boolean focusable = true; // lets taps outside the popup also dismiss it
//                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//
//                // show the popup window
//                // which view you pass in doesn't matter, it is only used for the window token
//                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);*/
//
//            }
//        });



    }
}