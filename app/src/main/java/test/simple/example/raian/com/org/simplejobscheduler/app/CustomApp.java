package test.simple.example.raian.com.org.simplejobscheduler.app;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by raian on 4/12/17.
 */

public class CustomApp extends Application{
    private static final String TAG = CustomApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "onLowMemory");
    }
}
