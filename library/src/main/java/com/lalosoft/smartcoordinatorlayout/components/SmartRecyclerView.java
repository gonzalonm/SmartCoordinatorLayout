package com.lalosoft.smartcoordinatorlayout.components;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.itemdecoration.DividerItemDecoration;

/**
 * Created by Gonzalo.Martin on 10/6/2016
 */

public abstract class SmartRecyclerView extends BaseSmartComponent implements SmartComponent {

    protected abstract RecyclerView.Adapter provideAdapter();

    @Override
    public View setup(Context context, ViewGroup view) {
        mContext = context;

        // find view by id
        RecyclerView mRecyclerView = new RecyclerView(context);
        mRecyclerView.setHasFixedSize(true);

        // add item decoration
        mRecyclerView.addItemDecoration(provideItemDecoration());

        // set layout manager
        RecyclerView.LayoutManager layoutManager = provideLayoutManager();
        if (layoutManager == null) {
            throw new IllegalStateException("LayoutManager provided is null");
        }
        mRecyclerView.setLayoutManager(layoutManager);

        // set recycler view adapter
        RecyclerView.Adapter adapter = provideAdapter();
        if (adapter == null) {
            throw new IllegalStateException("Provided adapter must not be null");
        }
        mRecyclerView.setAdapter(adapter);

        return mRecyclerView;
    }

    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    protected RecyclerView.ItemDecoration provideItemDecoration() {
        return new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST);
    }
}
