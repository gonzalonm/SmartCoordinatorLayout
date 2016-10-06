package com.lalosoft.smartcoordinatorlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Gonzalo.Martin on 9/30/2016
 */

public class SmartCoordinatorLayout {

    CoordinatorLayout mCoordinatorLayout;

    // Vars from Builder
    private Context mContext;
    private FloatingActionButtonListener mFloatingActionButtonListener;
    private ViewGroup rootView;
    private FABType mFabType;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    private List<?> mRecyclerViewData;
    private RecyclerView.ViewHolder mRecyclerViewHolder;
    private SmartRecyclerAdapterCallback mRecyclerAdapterCallback;

    private RecyclerView mRecyclerView;

    public interface SmartRecyclerAdapterCallback {
        void onBindSmartViewHolder(RecyclerView.ViewHolder viewHolder, Object data);
    }

    public interface FloatingActionButtonListener {

    }

    public enum FABType {
        NONE, ADD, EDIT
    }

    /**
     * Builder class for create an instance of SmartCoordinatorLayout
     */
    public static class Builder {
        private Context context;
        private FloatingActionButtonListener floatingActionButtonListener;
        private ViewGroup viewGroup = null;
        private FABType fabType;
        private RecyclerView.Adapter recyclerViewAdapter;
        private List<?> list;
        private RecyclerView.ViewHolder recyclerViewHolder;
        private SmartRecyclerAdapterCallback recyclerAdapterCallback;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder buildWithView(@NonNull ViewGroup view) {
            this.viewGroup = view;
            return this;
        }

        public Builder setFABListener(FloatingActionButtonListener fabListener) {
            this.floatingActionButtonListener = fabListener;
            return this;
        }

        /**
         * Instances FloatingActionButton
         *
         * @param fabType FloatingActionButton types: NONE, ADD, EDIT
         * @return Builder
         */
        public Builder useFloatingActionButton(@NonNull FABType fabType) {
            this.fabType = fabType;
            return this;
        }

        public Builder setRecyclerViewAdapter(@NonNull RecyclerView.Adapter recyclerViewAdapter) {
            this.recyclerViewAdapter = recyclerViewAdapter;
            return this;
        }

        public Builder setRecyclerViewData(@NonNull List<?> list, @NonNull RecyclerView.ViewHolder viewHolder,
                                           SmartRecyclerAdapterCallback recyclerAdapterCallback) {
            this.list = list;
            this.recyclerViewHolder = viewHolder;
            this.recyclerAdapterCallback = recyclerAdapterCallback;
            return this;
        }

        public SmartCoordinatorLayout build() {
            if (viewGroup == null) {
                throw new IllegalStateException("View cannot be null");
            }
            SmartCoordinatorLayout smartCoordinatorLayout = new SmartCoordinatorLayout();
            smartCoordinatorLayout.mContext = this.context;
            smartCoordinatorLayout.mFabType = fabType;
            smartCoordinatorLayout.mFloatingActionButtonListener = floatingActionButtonListener;
            smartCoordinatorLayout.rootView = viewGroup;
            smartCoordinatorLayout.mRecyclerViewAdapter = recyclerViewAdapter;
            smartCoordinatorLayout.mRecyclerViewData = list;
            smartCoordinatorLayout.mRecyclerViewHolder = recyclerViewHolder;
            smartCoordinatorLayout.mRecyclerAdapterCallback = recyclerAdapterCallback;
            return smartCoordinatorLayout;
        }
    }

    public void setup() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_main, rootView);
        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);

        // setup RecyclerView component
        setupRecyclerView(mCoordinatorLayout);
    }

    private void setupRecyclerView(View view) {
        // find view by id
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        if (mRecyclerViewAdapter == null) {
            // use custom adapter
            mRecyclerView.setAdapter(new CustomRecyclerViewAdapter(mRecyclerAdapterCallback,
                    mRecyclerViewData, mRecyclerViewHolder));
        } else {
            // use provided adapter
            mRecyclerView.setAdapter(mRecyclerViewAdapter);
        }
    }
}
