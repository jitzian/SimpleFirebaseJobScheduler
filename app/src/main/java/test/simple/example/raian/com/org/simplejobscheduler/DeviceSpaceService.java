package test.simple.example.raian.com.org.simplejobscheduler;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by raian on 3/25/17.
 */

public class DeviceSpaceService extends JobService {
    private static final String TAG = DeviceSpaceService.class.getSimpleName();
    @Override
    public boolean onStartJob(JobParameters job) {
        Log.d(TAG, "onStartJob");

        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());

        Log.d(TAG,
                " *** Free space is " +
                        (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() /1024) +
                        " Kb"
        );

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        Log.d(TAG, "onStopJob");
        return false;
    }
}
