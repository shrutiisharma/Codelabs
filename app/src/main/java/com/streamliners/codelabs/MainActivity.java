package com.streamliners.codelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Displays two Buttons and a TextView.
 * - Pressing the TOAST button shows a Toast.
 * - Pressing the COUNT button increases the displayed mCount.
 *
 */

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;                     //member variable mCount
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    /*
     * Shows a Toast when the TOAST button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since a toast always shows on the top,
     *             the passed in view is not used.
     */

    //onClick button_toast executes this fxn
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }


    /*
     * Increments the number in the TextView when the COUNT button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */

    //onClick button_count executes this fxn
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}