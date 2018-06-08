package com.adailtonribeiro.cordova.firebase;

import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import com.google.firebase.perf.FirebasePerformance;;

public class FirebasePerformancePlugin extends CordovaPlugin {
    private static final String TAG = "FirebasePerformancePlugin";

    private FirebasePerformance firebasePerformance;

    @Override
    protected void pluginInitialize() {
        Log.d(TAG, "Starting Firebase Performance plugin");

        this.firebasePerformance = FirebasePerformance.getInstance();
    }
}
