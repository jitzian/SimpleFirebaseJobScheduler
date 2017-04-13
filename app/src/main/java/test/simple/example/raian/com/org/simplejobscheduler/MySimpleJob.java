package test.simple.example.raian.com.org.simplejobscheduler;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by raian on 3/27/17.
 */

public class MySimpleJob extends JobService {
    private static final String TAG = MySimpleJob.class.getSimpleName();
    @Override
    public boolean onStartJob(JobParameters job) {
        Log.d(TAG, "onStartJob");
        FirebaseCrash.log(TAG + "::onStartJob");
        Toast.makeText(getApplicationContext(), "This is message in the job", Toast.LENGTH_LONG).show();
        Log.d(TAG, "*****");

        buildNotification();

        return true;
    }

    public void buildNotification(){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        Log.d(TAG, "onStopJob");
        return false;
    }
}
