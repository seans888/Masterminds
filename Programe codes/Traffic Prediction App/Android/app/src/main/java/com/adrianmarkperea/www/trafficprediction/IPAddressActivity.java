package com.adrianmarkperea.www.trafficprediction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IPAddressActivity extends Activity {

    private EditText mAddressEditText;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipaddress);

        mAddressEditText = findViewById(R.id.set_ip_address);
        mSubmitButton = findViewById(R.id.submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainMenuIntent = new Intent(IPAddressActivity.this, MainActivity.class);
                mainMenuIntent.putExtra("IP ADDRESS", mAddressEditText.getText().toString());
                startActivity(mainMenuIntent);
                finish();
            }

        });
    }
}
