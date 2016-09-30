package com.lalosoft.smartcoordinatorlayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .useFloatingActionButton(SmartCoordinatorLayout.FABType.NONE)
                .build();

        smartCoordinatorLayout.setup();
    }
}
