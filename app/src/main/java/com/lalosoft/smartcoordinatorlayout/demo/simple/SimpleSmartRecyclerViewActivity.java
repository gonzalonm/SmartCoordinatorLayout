package com.lalosoft.smartcoordinatorlayout.demo.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.components.recyclerview.SmartRecyclerView;
import com.lalosoft.smartcoordinatorlayout.demo.adapter.CustomAdapter;
import com.lalosoft.smartcoordinatorlayout.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo.Martin on 11/16/2016
 */
public class SimpleSmartRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.simple_smart_recycler_view);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView();

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
        for (int i = 0; i < 20; i++) {
            list.add("Item #" + i);
        }
        return list;
    }

    private class CustomSmartRecyclerView extends SmartRecyclerView {

        @Override
        protected RecyclerView.Adapter provideAdapter() {
            return new CustomAdapter(SimpleSmartRecyclerViewActivity.this, createStringList());
        }
    }

}
