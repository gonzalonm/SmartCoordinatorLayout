package com.lalosoft.smartcoordinatorlayout.demo.complex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.demo.OnItemSelectedListener;
import com.lalosoft.smartcoordinatorlayout.demo.R;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomAdapter;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomSmartRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo.Martin on 11/17/2016
 */

public class ComplexSmartComponentsActivity extends AppCompatActivity {

    private static final int ITEM_RECYCLER_VIEW_FAB = 0;
    private static final int ITEM_RECYCLER_VIEW_FAB_TAB = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.complex_smart_components);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView(new CustomAdapter(this,
                createStringList(), new OnItemSelectedListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case ITEM_RECYCLER_VIEW_FAB:
                        openActivity(ComplexSmartRecyclerViewFABActivity.class);
                        break;
                    case ITEM_RECYCLER_VIEW_FAB_TAB:
                        openActivity(ComplexSmartRecyclerViewFabTabActivity.class);
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
        list.add(getString(R.string.complex_smart_recycler_fab));
        list.add(getString(R.string.complex_smart_recycler_fab_tab));
        return list;
    }

    private void openActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }

}
