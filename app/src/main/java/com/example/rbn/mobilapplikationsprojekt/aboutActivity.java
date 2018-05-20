package com.example.rbn.mobilapplikationsprojekt;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Intent;

import android.widget.TextView;

public class aboutActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView aboutTitle = (TextView) findViewById(R.id.txt_about);
        aboutTitle.setText("About");
        TextView aboutDesc = (TextView) findViewById(R.id.txt_abouter);
        aboutDesc.setText("Fishapp! is an application for fish enthusiasts over the world looking to gain knowledge about popular seafood.");
    }




}
