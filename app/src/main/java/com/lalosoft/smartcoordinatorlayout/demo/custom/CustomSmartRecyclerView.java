package com.lalosoft.smartcoordinatorlayout.demo.custom;

import android.support.v7.widget.RecyclerView;

import com.lalosoft.smartcoordinatorlayout.components.recyclerview.SmartRecyclerView;

/**
 * Created by Gonzalo.Martin on 11/17/2016
 */
public class CustomSmartRecyclerView extends SmartRecyclerView {

    private BaseCustomAdapter adapter;

    public CustomSmartRecyclerView(BaseCustomAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected RecyclerView.Adapter provideAdapter() {
        return adapter;
    }
}
