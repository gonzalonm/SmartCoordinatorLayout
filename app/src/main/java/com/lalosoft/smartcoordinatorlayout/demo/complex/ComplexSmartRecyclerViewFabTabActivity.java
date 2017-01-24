package com.lalosoft.smartcoordinatorlayout.demo.complex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.components.fab.SmartFloatingActionButton;
import com.lalosoft.smartcoordinatorlayout.components.tablayout.SmartFragmentTab;
import com.lalosoft.smartcoordinatorlayout.components.tablayout.SmartFragmentTabLayout;
import com.lalosoft.smartcoordinatorlayout.demo.OnItemSelectedListener;
import com.lalosoft.smartcoordinatorlayout.demo.R;
import com.lalosoft.smartcoordinatorlayout.demo.TabFragment;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomAdapter;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomSmartRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonzalo on 24/01/17
 */

public class ComplexSmartRecyclerViewFabTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.complex_smart_recycler_fab_tab_title);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        // instances TabLayout
        SmartFragmentTabLayout smartFragmentTabLayout = new SmartFragmentTabLayout(getSupportFragmentManager());
        smartFragmentTabLayout.addTab(new SmartFragmentTab("TAB1", new RecyclerViewTabFragment()));
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

    public static class RecyclerViewTabFragment extends Fragment {

        private SmartCoordinatorLayout smartCoordinatorLayout;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_base, container, false);

            // bind the root of view of this activity
            ViewGroup rootView = (ViewGroup) view.findViewById(R.id.activity_base_root);

            // instances smart recycler view
            CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView(new CustomAdapter(getContext(),
                    createStringList(), new OnItemSelectedListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(getContext(), "Item #" + position, Toast.LENGTH_SHORT).show();
                }
            }));

            // instances FAB listener
            SmartFloatingActionButton.FloatingActionButtonListener fabListener = new SmartFloatingActionButton.FloatingActionButtonListener() {
                @Override
                public void onFABPressed() {
                    Toast.makeText(getContext(), R.string.fab_pressed, Toast.LENGTH_SHORT).show();
                }
            };

            // build SmartCoordinatorLayout
            smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(getContext())
                    .buildWithView(rootView)
                    .addSmartComponent(smartRecyclerView)
                    .addSmartComponent(new SmartFloatingActionButton(fabListener))
                    .build();

            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
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

}
