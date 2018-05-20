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
            viewName.setText(getIntent().getStringExtra("name"));

            TextView viewData = (TextView) findViewById(R.id.txt_data);
            viewData.setText(getIntent().getStringExtra("data"));

            TextView viewStats = (TextView) findViewById(R.id.txt_stats);
            viewStats.setText(getIntent().getStringExtra("stats"));
        }


    }

