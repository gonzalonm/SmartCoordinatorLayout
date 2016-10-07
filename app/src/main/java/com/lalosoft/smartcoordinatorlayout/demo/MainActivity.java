package com.lalosoft.smartcoordinatorlayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.components.SmartFloatingActionButton;
import com.lalosoft.smartcoordinatorlayout.components.SmartRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SmartFloatingActionButton.FloatingActionButtonListener fabListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_main);

        // instances FAB listener
        fabListener = new SmartFloatingActionButton.FloatingActionButtonListener() {
            @Override
            public void onFABPressed() {
                Toast.makeText(MainActivity.this, "FAB pressed!", Toast.LENGTH_SHORT).show();
            }
        };

        CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView();

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartRecyclerView) // Add SmartRecyclerView
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

    private class CustomSmartRecyclerView extends SmartRecyclerView {

        @Override
        protected RecyclerView.Adapter provideAdapter() {
            return new CustomAdapter(MainActivity.this, createStringList());
        }
    }
}
