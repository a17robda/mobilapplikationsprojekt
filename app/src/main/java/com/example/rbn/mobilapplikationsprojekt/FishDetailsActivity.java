package com.example.rbn.mobilapplikationsprojekt;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

    public class FishDetailsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fishdetails);


            TextView viewName = (TextView) findViewById(R.id.txt_name);
            viewName.setText(getIntent().getStringExtra("data"));
            /*
            int mH = getIntent().getIntExtra("height", 0);
            TextView viewHeight = (TextView) findViewById(R.id.txt_height);
            viewHeight.setText("Height: " + String.valueOf(mH) + "M");

            TextView viewLoc = (TextView) findViewById(R.id.txt_location);
            viewLoc.setText("Location: " + getIntent().getStringExtra("location"));
            */
        }


    }

