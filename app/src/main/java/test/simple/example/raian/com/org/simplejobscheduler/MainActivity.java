package test.simple.example.raian.com.org.simplejobscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.JobTrigger;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mButtonStart, mButton2;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

//        FirebaseJobDispatcher dispatcher =
//                new FirebaseJobDispatcher(
//                        new GooglePlayDriver(MainActivity.this)
//                );
//
//        dispatcher.mustSchedule(
//                dispatcher.newJobBuilder()
//                        .setService(DeviceSpaceService.class)
//                        .setTag("DeviceSpaceServiceTAG")
//                        .setRecurring(true)
//                        .setTrigger(Trigger.executionWindow(10, 20))
//                        .build());

        FirebaseJobDispatcher firebaseJobDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(MainActivity.this));

        Job job = firebaseJobDispatcher.newJobBuilder()
                .setService(MySimpleJob.class)
                .setRecurring(true)
                .setTag("ToastServiceTAG")
                .setTrigger(Trigger.executionWindow(15, 25))
                .setReplaceCurrent(true)
                .build();

        firebaseJobDispatcher.schedule(job);

    }
}