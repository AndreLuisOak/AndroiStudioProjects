package com.example.workmanager;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkRequest simpleWorkRequest = new OneTimeWorkRequest.Builder(SimpleWorker.class).build();
        WorkManager.getInstance(this).enqueue(simpleWorkRequest);

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(simpleWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if (workInfo != null) {
                            Toast.makeText(MainActivity.this, "Status: " +
                                    workInfo.getState(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true).build();

        WorkRequest constrainedWorkRequest = new OneTimeWorkRequest.Builder(SimpleWorker.class)
                .setConstraints(constraints).build();

        WorkManager.getInstance(this).enqueue(constrainedWorkRequest);
    }
}