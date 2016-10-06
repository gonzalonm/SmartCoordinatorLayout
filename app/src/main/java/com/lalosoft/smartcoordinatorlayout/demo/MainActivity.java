package com.lalosoft.smartcoordinatorlayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_main);

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .useFloatingActionButton(SmartCoordinatorLayout.FABType.NONE)
                .setRecyclerViewAdapter(new MyAdapter(createStringList()))
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

    /**
     * Implements the custom adapter to use in the RecyclerView
     */
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private List<String> list;

        public MyAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.text.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView text;

            public MyViewHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.item_text);
            }
        }
    }
}
