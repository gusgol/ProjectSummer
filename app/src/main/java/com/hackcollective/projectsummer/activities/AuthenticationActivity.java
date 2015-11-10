package com.hackcollective.projectsummer.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hackcollective.projectsummer.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A login screen that offers login via email/password.
 */
public class AuthenticationActivity extends AppCompatActivity {

    // Member variables
    private Context mContext;

    // View
    @Bind(R.id.button_login) Button mLoginButton;
    @Bind(R.id.button_signup) Button mSignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        ButterKnife.bind(this);

        mContext = this;

        mLoginButton.setOnClickListener(mOnLoginClicked);
        mSignUpButton.setOnClickListener(mOnSignUpClicked);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFacebookLoginClicked();
            }
        });

    }

    private void onFacebookLoginClicked() {
        List<String> permissions = Arrays.asList("public_profile");
        ParseFacebookUtils.logInWithReadPermissionsInBackground(this, permissions, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException err) {
                if (user == null) {
                    Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
                } else if (user.isNew()) {
                    Log.d("MyApp", "User signed up and logged in through Facebook!");
                } else {
                    Log.d("MyApp", "User logged in through Facebook!");
                }
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }

    private View.OnClickListener mOnSignUpClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, SignUpActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener mOnLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(mContext, SignUpActivity.class);
//            startActivity(intent);
        }
    };

}

