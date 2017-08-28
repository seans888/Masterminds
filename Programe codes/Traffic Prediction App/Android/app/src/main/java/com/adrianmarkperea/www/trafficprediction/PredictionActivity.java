package com.adrianmarkperea.www.trafficprediction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

import static java.security.AccessController.getContext;

public class PredictionActivity extends Activity {

    public static final String JAM_LEVEL = "com.adrianmarkperea.www.trafficprediction.JAM_LEVEL";
    public static final String FROM = "com.adrianmarkperea.www.trafficprediction.FROM";
    public static final String TO = "com.adrianmarkperea.www.trafficprediction.TO";
    public static final String MONTH = "com.adrianmarkperea.www.trafficprediction.MONTH";
    public static final String DAY = "com.adrianmarkperea.www.trafficprediction.DAY";
    public static final String YEAR = "com.adrianmarkperea.www.trafficprediction.YEAR";
    public static final String TIME = "com.adrianmarkperea.www.trafficprediction.TIME";

    private TextView mJamLevelTextView;
    private TextView mFromTextView;
    private TextView mToTextView;
    private TextView mDateTextView;
    private TextView mTimeTextView;

    private int mJamLevel;
    private String mFrom;
    private String mTo;
    private int mMonth;
    private int mDay;
    private int mYear;
    private int mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        Intent intent = getIntent();
        mJamLevel = intent.getIntExtra(JAM_LEVEL, -1);
        mFrom = intent.getStringExtra(FROM);
        mTo = intent.getStringExtra(TO);
        mMonth = intent.getIntExtra(MONTH, -1);
        mDay = intent.getIntExtra(DAY, -1);
        mYear = intent.getIntExtra(YEAR, -1);
        mTime = intent.getIntExtra(TIME, -1);

        mJamLevelTextView = findViewById(R.id.jam_level);

        GradientDrawable jamLevelCircle = (GradientDrawable) mJamLevelTextView.getBackground();
        int jamLevelColor = getJamLevelColor(mJamLevel);
        jamLevelCircle.setColor(jamLevelColor);

        mJamLevelTextView.setText(Integer.toString(mJamLevel));

        mFromTextView = findViewById(R.id.from);
        mFromTextView.setText(mFrom);

        mToTextView = findViewById(R.id.to);
        mToTextView.setText(mTo);

        mTimeTextView = findViewById(R.id.time);
        mTimeTextView.setText(String.format(Locale.getDefault(), "%02d", mTime) + ":00");


    }

    private int getJamLevelColor(int jamLevel) {
        int jamLevelColorResourceId;
        switch (jamLevel) {
            case 1:
                jamLevelColorResourceId = R.color.jam1;
                break;
            case 2:
                jamLevelColorResourceId = R.color.jam2;
                break;
            case 3:
                jamLevelColorResourceId = R.color.jam3;
                break;
            case 4:
                jamLevelColorResourceId = R.color.jam4;
                break;
            case 5:
                jamLevelColorResourceId = R.color.jam5;
                break;
            default:
                jamLevelColorResourceId = R.color.jam1;
                break;
        }
        return this.getResources().getColor(jamLevelColorResourceId );

    }
}

