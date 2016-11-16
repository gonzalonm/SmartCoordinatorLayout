package com.lalosoft.smartcoordinatorlayout.demo.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.components.tablayout.SmartFragmentTab;
import com.lalosoft.smartcoordinatorlayout.components.tablayout.SmartFragmentTabLayout;
import com.lalosoft.smartcoordinatorlayout.demo.R;
import com.lalosoft.smartcoordinatorlayout.demo.TabFragment;

/**
 * Created by Gonzalo.Martin on 11/16/2016
 */

public class SimpleSmartTabLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.simple_smart_tab_layout);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        SmartFragmentTabLayout smartFragmentTabLayout = new SmartFragmentTabLayout(getSupportFragmentManager());
        smartFragmentTabLayout.addTab(new SmartFragmentTab("TAB1", TabFragment.newInstance("Tab 1")));
        smartFragmentTabLayout.addTab(new SmartFragmentTab("TAB2", TabFragment.newInstance("Tab 2")));
        smartFragmentTabLayout.addTab(new SmartFragmentTab("TAB3", TabFragment.newInstance("Tab 3")));

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartFragmentTabLayout)
                .build();

        smartCoordinatorLayout.setup();
    }

}
