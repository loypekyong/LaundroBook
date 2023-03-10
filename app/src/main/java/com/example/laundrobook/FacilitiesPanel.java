package com.example.laundrobook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;
import android.view.*;
import android.widget.*;

public class FacilitiesPanel extends AppCompatActivity {

    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_panel);
        nextButton = findViewById(R.id.W1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // inflate the layout of the popup window
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
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

            }
        });
    }
}