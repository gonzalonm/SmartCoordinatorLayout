package com.lalosoft.smartcoordinatorlayout.demo.complex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.components.fab.SmartFloatingActionButton;
import com.lalosoft.smartcoordinatorlayout.demo.OnItemSelectedListener;
import com.lalosoft.smartcoordinatorlayout.demo.R;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomAdapter;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomSmartRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo.Martin on 11/17/2016
 */
public class ComplexSmartRecyclerViewFABActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.complex_smart_recycler_fab);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        // instances smart recycler view
        CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView(new CustomAdapter(this,
                createStringList(), new OnItemSelectedListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(ComplexSmartRecyclerViewFABActivity.this, "Item #" + position, Toast.LENGTH_SHORT).show();
            }
        }));

        // instances FAB listener
        SmartFloatingActionButton.FloatingActionButtonListener fabListener = new SmartFloatingActionButton.FloatingActionButtonListener() {
            @Override
            public void onFABPressed() {
                Toast.makeText(ComplexSmartRecyclerViewFABActivity.this, R.string.fab_pressed, Toast.LENGTH_SHORT).show();
            }
        };

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartRecyclerView)
                .addSmartComponent(new SmartFloatingActionButton(fabListener))
                .build();

        smartCoordinatorLayout.setup();
    }

    private List<String> createStringList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item #" + i);
        }
        return list;
    }
}
