package com.adrianmarkperea.www.trafficprediction;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private Button mStartButton;

//    private UserLoginTask mAuthTask = null;

    private final String[] CREDENTIALS = {"test:test"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mStartButton = findViewById(R.id.start);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ipAddressActivityIntent = new Intent(LoginActivity.this, IPAddressActivity.class);
                startActivity(ipAddressActivityIntent);
                finish();
            }
        });

    }

//    private void attemptSignIn() {
//        mUsernameEditText.setError(null);
//        mPasswordEditText.setError(null);
//
//        String username = mUsernameEditText.getText().toString();
//        String password = mPasswordEditText.getText().toString();
//
//        boolean cancel = false;
//
//        if (TextUtils.isEmpty(username)) {
//            mUsernameEditText.setError("This field is required.");
//            mUsernameEditText.requestFocus();
//            cancel = true;
//        }
//
//        if (!cancel) {
//            mAuthTask = new UserLoginTask(username, password);
//            mAuthTask.execute((Void) null);
//        }
//        ;
//    }
//
//    private class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
//
//        private final String mUsername;
//        private final String mPassword;
//
//        UserLoginTask(String username, String password) {
//            mUsername = username;
//            mPassword = password;
//        }
//
//        @Override
//        protected Boolean doInBackground(Void... params) {
//            // Simulate network access
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                return false;
//            }
//            for (String credential : CREDENTIALS) {
//                String[] pieces = credential.split(":");
//                if (pieces[0].equals(mUsername)) {
//                    // Account exists, return true if the password matches.
//                    return pieces[1].equals(mPassword);
//                }
//            }
//            return false;
//        }
//
//        @Override
//        protected void onPostExecute(final Boolean success) {
//            mAuthTask = null;
//            if (success) {
//                Intent mainMenuIntent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(mainMenuIntent);
//                finish();
//            } else {
//                mPasswordEditText.setError("Incorrect password");
//                mPasswordEditText.requestFocus();
//            }
//        }
//
//        @Override
//        protected void onCancelled() {
//            mAuthTask = null;
//
//        }
//
//    }

}
