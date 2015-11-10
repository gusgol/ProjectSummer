package com.hackcollective.projectsummer;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by Gustavo on 11/3/15.
 */
public class SummerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "vkuI15QuIGUYZeQjPNBGtpEUCpKAmD66S1Qax8S5", "WfSLTTVfKq8tQuymz1ClYf63irFXBo7qjJvGQWwa");
        ParseFacebookUtils.initialize(this);
    }
}
