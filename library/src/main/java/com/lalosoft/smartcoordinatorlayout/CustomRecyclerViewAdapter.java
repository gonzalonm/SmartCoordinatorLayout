package com.lalosoft.smartcoordinatorlayout;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Gonzalo.Martin on 10/5/2016
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    private final SmartCoordinatorLayout.SmartRecyclerAdapterCallback callback;
    private List<?> list;
    private RecyclerView.ViewHolder viewHolder;

    public CustomRecyclerViewAdapter(SmartCoordinatorLayout.SmartRecyclerAdapterCallback mRecyclerAdapterCallback,
                                     List<?> mRecyclerViewData, RecyclerView.ViewHolder mRecyclerViewHolder) {
        this.callback = mRecyclerAdapterCallback;
        this.list = mRecyclerViewData;
        this.viewHolder = mRecyclerViewHolder;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        callback.onBindSmartViewHolder(holder, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
