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


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FetchData().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            new FetchData().execute();
            return true;
        }
        if (id == R.id.action_about) {
            Intent aboutIntent = new Intent(MainActivity.this, aboutActivity.class);
            startActivity(aboutIntent);
        }
        return super.onOptionsItemSelected(item);

    }

    private class FetchData extends AsyncTask<Void,Void,String>{
        @Override
        protected String doInBackground(Void... params) {

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            String jsonStr = null;

            try {

                URL url = new URL("http://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a17robda");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {

                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {

                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {

                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);

                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }
        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
            Log.d("tomten", "DataFetched:" + o);

            ListView listview = (ListView)findViewById(R.id.my_listview);
            final ArrayList<String> fishList = new ArrayList<String>();
            final ArrayList<String> fishData = new ArrayList<String>();
            final ArrayList<String> fishStats = new ArrayList<String>();

            ArrayAdapter<String> myadapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item_view, R.id.my_listitem, fishList);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   // Toast.makeText(MainActivity.this, fishData.get(i), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FishDetailsActivity.class);
                    intent.putExtra("data", fishData.get(i));
                    intent.putExtra("name", fishList.get(i));
                    intent.putExtra("stats", fishStats.get(i));
                    startActivity(intent);

                }
            });

            try {
                JSONArray jArr = new JSONArray(o);
                for (int i = 0; i < jArr.length(); i++) {
                    JSONObject jObj = jArr.getJSONObject(i);

                    String fName = jObj.getString("name");
                    String fLocation = jObj.getString("location");
                    String fCategory = jObj.getString("category");
                    int Calories = jObj.getInt("size");
                    String fCalories = Integer.toString(Calories);
                    int Price = jObj.getInt("cost");
                    String fPrice = Integer.toString(Price);
                    String fDescription = jObj.getString("auxdata");

                    Fish myFish = new Fish(fName, fLocation, fCategory, fCalories, fPrice, fDescription);

                    String mName = myFish.nameGet();
                    fishList.add(mName);

                    String mData = myFish.messageGet();
                    fishData.add(mData);

                    String fStats = myFish.statsGet();
                    fishStats.add(fStats);

                }

            }catch(JSONException e){
                Log.e("brom", "E:" + e.getMessage());
            }

            listview.setAdapter(myadapter);
        }

    }
}
