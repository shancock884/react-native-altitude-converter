package com.shancock.altitudeconverter;

import java.io.IOException;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.util.Log;
import android.location.Location;
import androidx.core.location.LocationCompat;
import androidx.core.location.altitude.AltitudeConverterCompat;

public class RNAltitudeConverterModule extends ReactContextBaseJavaModule {
  public static final String TAG = "RNAltitudeConverter";
  public final ReactApplicationContext mReactContext;

  public RNAltitudeConverterModule(ReactApplicationContext reactContext) {
    super(reactContext);
    mReactContext = reactContext;
  }

  @Override
  public String getName() {
    return TAG;
  }

  @ReactMethod
  public void getMSLAltitudeDelta(double lat, double lon, final Promise promise) {
    try {
        String s = null;
        Location loc = new Location(s);
        loc.setLatitude(lat);
        loc.setLongitude(lon);
        loc.setAltitude(0);
        AltitudeConverterCompat.addMslAltitudeToLocation(mReactContext, loc);
        promise.resolve(LocationCompat.getMslAltitudeMeters(loc));
    } catch (IOException e) {
        Log.w(TAG, "Android's AltitudeConverterCompat failed with " + e.getMessage());
        promise.reject(e.getMessage());
    }
  }
}
