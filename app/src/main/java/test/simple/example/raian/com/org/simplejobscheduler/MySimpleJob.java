package test.simple.example.raian.com.org.simplejobscheduler;

import android.util.Log;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by raian on 3/27/17.
 */

public class MySimpleJob extends JobService {
    private static final String TAG = MySimpleJob.class.getSimpleName();
    @Override
    public boolean onStartJob(JobParameters job) {
        Log.d(TAG, "onStartJob");
        Toast.makeText(getApplicationContext(), "This is message in the job", Toast.LENGTH_LONG).show();

//        Thread myThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.d(TAG, "******************");
//            }
//        });
//
//        myThread.start();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        Log.d(TAG, "onStopJob");
        return false;
    }
}
