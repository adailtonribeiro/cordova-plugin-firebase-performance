package com.adailtonribeiro.cordova.firebase;

import java.util.HashMap;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;

public class FirebasePerformancePlugin extends CordovaPlugin {
  private static final String TAG = "FirebasePerfPlugin";

  private FirebasePerformance firebasePerformance;
  private HashMap<String, Trace> traces = new HashMap<String, Trace>();

  @Override
  protected void pluginInitialize() {
    Log.d(TAG, "Starting Firebase Performance plugin");

    this.firebasePerformance = FirebasePerformance.getInstance();
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if ("startTrace".equals(action)) {
      startTrace(callbackContext, args.getString(0));
      return true;
    } else if ("stopTrace".equals(action)) {
      stopTrace(callbackContext, args.getString(0));
      return true;
    } else if ("incrementCounter".equals(action)) {
      incrementCounter(callbackContext, args.getString(0), args.getString(1));
      return true;
    }

    return false;
  }

  private void startTrace(final CallbackContext callbackContext, final String name) {
    final FirebasePerformancePlugin self = this;
    cordova.getThreadPool().execute(new Runnable() {
      public void run() {
        try {

          Trace myTrace = null;
          if (self.traces.containsKey(name)) {
            myTrace = self.traces.get(name);
          }

          if (myTrace == null) {
            myTrace = self.firebasePerformance.newTrace(name);
            myTrace.start();
            self.traces.put(name, myTrace);
          }

          callbackContext.success();
        } catch (Exception e) {
          e.printStackTrace();
          callbackContext.error(e.getMessage());
        }
      }
    });
  }

  private void incrementCounter(final CallbackContext callbackContext, final String name, final String counterNamed) {
    final FirebasePerformancePlugin self = this;
    cordova.getThreadPool().execute(new Runnable() {
      public void run() {
        try {

          Trace myTrace = null;
          if (self.traces.containsKey(name)) {
            myTrace = self.traces.get(name);
          }

          if (myTrace != null) {
            myTrace.incrementMetric(counterNamed, 1);
            callbackContext.success();
          } else {
            callbackContext.error("Trace not found");
          }

        } catch (Exception e) {
          e.printStackTrace();
          callbackContext.error(e.getMessage());
        }
      }
    });
  }

  private void stopTrace(final CallbackContext callbackContext, final String name) {
    final FirebasePerformancePlugin self = this;
    cordova.getThreadPool().execute(new Runnable() {
      public void run() {
        try {

          Trace myTrace = null;
          if (self.traces.containsKey(name)) {
            myTrace = self.traces.get(name);
          }

          if (myTrace != null) {
            myTrace.stop();
            self.traces.remove(name);
            callbackContext.success();
          } else {
            callbackContext.error("Trace not found");
          }

        } catch (Exception e) {
          e.printStackTrace();
          callbackContext.error(e.getMessage());
        }
      }
    });
  }
}
