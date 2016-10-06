package com.lalosoft.smartcoordinatorlayout.components;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lalosoft.smartcoordinatorlayout.R;
import com.lalosoft.smartcoordinatorlayout.itemdecoration.DividerItemDecoration;

/**
 * Created by Gonzalo.Martin on 10/6/2016
 */

public abstract class SmartRecyclerView implements SmartComponent {

    private Context mContext;

    protected abstract RecyclerView.Adapter provideAdapter();

    @Override
    public void setup(Context context, View view) {
        mContext = context;

        // find view by id
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
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
    }

    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    protected RecyclerView.ItemDecoration provideItemDecoration() {
        return new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST);
    }
}
