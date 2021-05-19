package com.streamliners.codelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.streamliners.codelabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //create object for view binding
    ActivityMainBinding b;

    private int backgroundClr;
    private int count = 0;

    SharedPreferences mPreferences;

    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";

    /**
     * It initialises the activity.
     * @param savedInstanceState : reference to a Bundle object that is passed into the onCreate method of every Android Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupLayout();

        // Initialize Shared Preferences
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        // Restore preferences
        if (mPreferences != null) {
            count = mPreferences.getInt(Constants.COUNT_KEY, 0);
            b.output.setText(String.format("%s", count));
            backgroundClr = mPreferences.getInt(Constants.COLOR_KEY, getResources().getColor(R.color.gray));
            b.output.setBackgroundColor(backgroundClr);
        }
    }

    /**
     * To set the layout of the sharedPrefsActivity
     */
    private void setupLayout() {
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setTitle("Hello Shared Preferences");
    }

    public void setBlackClrBackground(View view) {
        backgroundClr = getResources().getColor(R.color.black);
        updateBackgroundColor();
    }

    public void setRedClrBackground(View view) {
        backgroundClr = getResources().getColor(R.color.red);
        updateBackgroundColor();
    }

    public void setBlueClrBackground(View view) {
        backgroundClr = getResources().getColor(R.color.blue);
        updateBackgroundColor();
    }

    public void setGreenClrBackground(View view) {
        backgroundClr = getResources().getColor(R.color.green);
        updateBackgroundColor();
    }

    private void updateBackgroundColor() {
        b.output.setBackgroundColor(backgroundClr);
    }

    public void incCount(View view) {
        count ++;
        b.output.setText(String.valueOf(count));
    }

    public void resetOutput(View view) {

        // Reset background color
        backgroundClr = getResources().getColor(R.color.gray);
        updateBackgroundColor();

        // Reset count
        count = 0;
        b.output.setText(String.valueOf(count));

        // Clear preferences
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }


    @Override
    protected void onPause() {
        super.onPause();

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(Constants.COUNT_KEY, count);
        preferencesEditor.putInt(Constants.COLOR_KEY, backgroundClr);
        preferencesEditor.apply();
    }
}