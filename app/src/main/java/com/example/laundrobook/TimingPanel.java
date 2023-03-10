package com.example.laundrobook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.view.View;
import android.widget.*;

public class TimingPanel extends AppCompatActivity {

    Button W0700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing_panel);
        W0700 = findViewById(R.id.W0700);
        W0700.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                View FacilitiesPanel = getLayoutInflater().inflate(R.layout.activity_facilities_panel, null);
                setContentView(FacilitiesPanel);
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
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);*/

            }
        });
    }
}