package edu.psu.sweng888.lessontwolifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String CURRENT_STATE = "Current State: ";
    private final String CALLED_WHEN = "Called When: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Define the breakpoint for each method, and run the app in Debug mode.
     * It will show when each of these methods are called. Open the Logcat
     * (not the debugger, not the console), and check messages tagged with
     * letter D.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(CURRENT_STATE, "onStart()");
        Log.d(CALLED_WHEN, "the activity is about to become visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(CURRENT_STATE, "onResume()");
        Log.d(CALLED_WHEN, "activity will be ready to start interacting with the user");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(CURRENT_STATE, "onPause()");
        Log.d(CALLED_WHEN, "the activity is taking focus");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(CURRENT_STATE, "onStop()");
        Log.d(CALLED_WHEN, "the activity is no longer visible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(CURRENT_STATE, "onDestroy()");
        Log.d(CALLED_WHEN, "the activity is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(CURRENT_STATE, "onRestart()");
        Log.d(CALLED_WHEN, "the activity stopped prior to start");
    }
}