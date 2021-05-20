package com.streamliners.codelabs;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.streamliners.codelabs.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        setTitle("Color My Views");
        setupEventHandlers();
    }


    /**
     * To give color to the view accordingly
     * @param view view to be colored
     */
    private void makeColored(View view) {
        // checking the id of the view and setting the color to it accordingly
        if (view.getId() == b.boxOneText.getId()) {
            view.setBackgroundColor(Color.DKGRAY);
        } else if (view.getId() == b.boxTwoText.getId()) {
            view.setBackgroundColor(Color.GRAY);
        } else if (view.getId() == b.boxThreeText.getId()) {
            view.setBackgroundColor(Color.BLUE);
        } else if (view.getId() == b.boxFourText.getId()) {
            view.setBackgroundColor(Color.MAGENTA);
        } else if (view.getId() == b.boxFiveText.getId()) {
            view.setBackgroundColor(Color.BLUE);
        } else if (view.getId() == b.redButton.getId()) {
            b.boxThreeText.setBackgroundColor(getResources().getColor(R.color.red));
        } else if (view.getId() == b.yellowButton.getId()) {
            b.boxFourText.setBackgroundColor(getResources().getColor(R.color.yellow));
        } else if (view.getId() == b.greenButton.getId()) {
            b.boxFiveText.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            view.setBackgroundColor(Color.LTGRAY);
        }
    }


    /**
     *  Set event handlers(onClick) for views
     */
    private void setupEventHandlers() {
        // list of all the clickable views
        List<View> clickableViews = new ArrayList<>(
                Arrays.asList(b.boxOneText, b.boxTwoText, b.boxThreeText,
                        b.boxFourText, b.boxFiveText, b.constraintLayout,
                        b.redButton, b.yellowButton, b.greenButton)
        );

        // setting the on click listeners to all the views using loop
        for (View item :
                clickableViews) {
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    makeColored(item);
                }
            });
        }
    }
}