package com.lalosoft.smartcoordinatorlayout.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.demo.complex.ComplexSmartComponentsActivity;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomAdapter;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomSmartRecyclerView;
import com.lalosoft.smartcoordinatorlayout.demo.simple.SimpleSmartComponentsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ITEM_SIMPLE_SMART_COMPONENTS = 0;
    private static final int ITEM_COMPLEX_SMART_COMPONENTS = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView(new CustomAdapter(this, createStringList(),
                new OnItemSelectedListener() {
                    @Override
                    public void onItemClick(int position) {
                        switch (position) {
                            case ITEM_SIMPLE_SMART_COMPONENTS:
                                openActivity(SimpleSmartComponentsActivity.class);
                                break;
                            case ITEM_COMPLEX_SMART_COMPONENTS:
                                openActivity(ComplexSmartComponentsActivity.class);
                                break;
                        }
                    }
                }));

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartRecyclerView)
                .build();

        smartCoordinatorLayout.setup();
    }

    private List<String> createStringList() {
        List<String> list = new ArrayList<>();
        list.add(getString(R.string.simple_smart_components));
        list.add(getString(R.string.complex_smart_components));
        return list;
    }

    private void openActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }
}
