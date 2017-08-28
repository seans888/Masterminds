package com.adrianmarkperea.www.trafficprediction;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private Spinner mFromSpinner;
    private Spinner mToSpinner;
    private ArrayAdapter<String> mFromSpinnerAdapter;
    private ArrayAdapter<String> mToSpinnerAdapter;
    private Spinner mDaySpinner;
    private SeekBar mTimeSeekBar;
    private TextView mTimeTextView;
    private Button mPredictButton;

    private String mFromLocation;
    private String mToLocation;
    private int mSelectedTime = 0;
    private String mSelectedDay = "Monday";

    private String mIPAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        mIPAddress = intent.getStringExtra("IP ADDRESS");
        Log.v("IP ADDRESS::::", mIPAddress);

        mFromSpinner = findViewById(R.id.from_spinner);
        mToSpinner = findViewById(R.id.to_spinner);
        mDaySpinner = findViewById(R.id.day_spinner);

//        ArrayAdapter<CharSequence> fromSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.locations_array,
//                android.R.layout.simple_spinner_item);
//        fromSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mFromSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<String>());
        mFromSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mFromSpinner.setAdapter(mFromSpinnerAdapter);
        mFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mFromLocation = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> daySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.days_array,
                android.R.layout.simple_spinner_item);
        daySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDaySpinner.setAdapter(daySpinnerAdapter);
        mDaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectedDay = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        ArrayAdapter<CharSequence> toSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.locations_array,
//                android.R.layout.simple_spinner_item);
//        toSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                mToSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<String>());
        mToSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mToSpinner.setAdapter(mToSpinnerAdapter);
        mToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mToLocation = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        mTimeTextView = findViewById(R.id.time);
        mTimeSeekBar = findViewById(R.id.seekbar);

        mTimeSeekBar.setOnSeekBarChangeListener(this);

        mPredictButton = findViewById(R.id.predict);
        mPredictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String baseURL = "http://" + mIPAddress + ":3000/api/jamlevel/" + mFromLocation + "/" + mToLocation + "/" + mSelectedDay + "/" + mSelectedTime;
                String url = baseURL.replace(" ", "+");
                Log.v("URL: ", url);

//                new JamLevelAsyncTask().execute("http://192.168.1.10:3000/api/jamlevel/2382+Mabolo%2C+Makati%2C+Metro+Manila%2C+Philippines/2382+Mabolo%2C+Makati%2C+Metro+Manila%2C+Philippines/Monday/0");
                new JamLevelAsyncTask().execute(url);
            }
        });


        new OriginAsyncTask().execute("http://" + mIPAddress + ":3000/api/origins");
        new DestinationAsyncTask().execute("http://" + mIPAddress + ":3000/api/destinations");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        mSelectedTime = i;
        String time = String.format(Locale.getDefault(), "%02d", i) + ":00";
        mTimeTextView.setText(time);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        mTimeTextView.setTypeface(null, Typeface.BOLD);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTimeTextView.setTypeface(null, Typeface.NORMAL);
    }




    private class OriginAsyncTask extends AsyncTask<String, Void, List<String>> {
        @Override
        protected List<String> doInBackground(String... urls) {

            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            return QueryUtils.fetchOrigins(urls[0]);
        }

        @Override
        protected void onPostExecute(List<String> origins) {
            super.onPostExecute(origins);

            if (origins.isEmpty()) {
                return;
            }
            mFromSpinnerAdapter.addAll(origins);
        }
    }

    private class DestinationAsyncTask extends AsyncTask<String, Void, List<String>> {
        @Override
        protected List<String> doInBackground(String... urls) {

            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            return QueryUtils.fetchDestinations(urls[0]);
        }

        @Override
        protected void onPostExecute(List<String> destinations) {
            super.onPostExecute(destinations);

            if (destinations.isEmpty()) {
                return;
            }
            mToSpinnerAdapter.addAll(destinations);
        }
    }

    private class JamLevelAsyncTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return -1;
            }

            return QueryUtils.fetchJamLevel(urls[0]);
        }

        @Override
        protected void onPostExecute(Integer jamLevel) {
            super.onPostExecute(jamLevel);

            // Do something
            Intent intent = new Intent(MainActivity.this, PredictionActivity.class);
            // DUMMY JAM LEVEL
            intent.putExtra(PredictionActivity.JAM_LEVEL, jamLevel);
            intent.putExtra(PredictionActivity.FROM, mFromLocation);
            intent.putExtra(PredictionActivity.TO, mToLocation);
            intent.putExtra(PredictionActivity.TIME, mSelectedTime);
            startActivity(intent);
        }
    }

}
