package com.streamliners.codelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.streamliners.codelabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //create object for view binding
    ActivityMainBinding b;


    /**
     * It initialises the activity.
     * @param savedInstanceState : reference to a Bundle object that is passed into the onCreate method of every Android Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupLayout();
    }

    /**
     * To set the layout of the MainActivity
     */
    private void setupLayout() {
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setTitle("Layout CodeLab");
    }

}