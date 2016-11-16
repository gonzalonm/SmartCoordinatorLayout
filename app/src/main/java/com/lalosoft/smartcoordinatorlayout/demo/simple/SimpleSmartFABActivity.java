package com.lalosoft.smartcoordinatorlayout.demo.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.components.fab.SmartFloatingActionButton;
import com.lalosoft.smartcoordinatorlayout.demo.R;

/**
 * Created by Gonzalo.Martin on 11/16/2016
 */

public class SimpleSmartFABActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.simple_smart_floating_action_button);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        // instances FAB listener
        SmartFloatingActionButton.FloatingActionButtonListener fabListener = new SmartFloatingActionButton.FloatingActionButtonListener() {
            @Override
            public void onFABPressed() {
                Toast.makeText(SimpleSmartFABActivity.this, R.string.fab_pressed, Toast.LENGTH_SHORT).show();
            }
        };

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(new SmartFloatingActionButton(fabListener))
                .build();

        smartCoordinatorLayout.setup();
    }
}
