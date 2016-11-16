package com.lalosoft.smartcoordinatorlayout.demo.simple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.components.recyclerview.SmartRecyclerView;
import com.lalosoft.smartcoordinatorlayout.demo.OnItemSelectedListener;
import com.lalosoft.smartcoordinatorlayout.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo.Martin on 11/16/2016
 */

public class SimpleSmartComponentsActivity extends AppCompatActivity {

    private static final int ITEM_RECYCLER_VIEW = 0;
    private static final int ITEM_FAB = 1;
    private static final int ITEM_TAB_LAYOUT = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.simple_smart_components);
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
        list.add(getString(R.string.simple_smart_recycler_view));
        list.add(getString(R.string.simple_smart_floating_action_button));
        list.add(getString(R.string.simple_smart_tab_layout));
        return list;
    }

    private void openActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }

    private class CustomSmartRecyclerView extends SmartRecyclerView {

        @Override
        protected RecyclerView.Adapter provideAdapter() {
            return new SimpleSmartComponentsAdapter(createStringList(), new OnItemSelectedListener() {
                @Override
                public void onItemClick(int position) {
                    switch (position) {
                        case ITEM_RECYCLER_VIEW:
                            openActivity(SimpleSmartRecyclerViewActivity.class);
                            break;
                        case ITEM_FAB:
                            openActivity(SimpleSmartFABActivity.class);
                            break;
                        case ITEM_TAB_LAYOUT:
                            openActivity(SimpleSmartTabLayoutActivity.class);
                            break;
                    }
                }
            });
        }
    }

    private class SimpleSmartComponentsAdapter extends RecyclerView.Adapter<SimpleSmartComponentsAdapter.SimpleViewHolder> {

        private final OnItemSelectedListener listener;
        private List<String> list;

        public SimpleSmartComponentsAdapter(List<String> list, OnItemSelectedListener listener) {
            this.list = list;
            this.listener = listener;
        }

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(SimpleSmartComponentsActivity.this).inflate(R.layout.view_item, parent, false);
            return new SimpleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final SimpleViewHolder holder, int position) {
            holder.text.setText(list.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(holder.getAdapterPosition());
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class SimpleViewHolder extends RecyclerView.ViewHolder {
            TextView text;

            public SimpleViewHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.item_text);
            }
        }
    }

}
