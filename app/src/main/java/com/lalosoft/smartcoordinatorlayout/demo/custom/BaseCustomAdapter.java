package com.lalosoft.smartcoordinatorlayout.demo.custom;

import android.support.v7.widget.RecyclerView;

import com.lalosoft.smartcoordinatorlayout.demo.OnItemSelectedListener;

/**
 * Created by Gonzalo.Martin on 11/17/2016
 */

public abstract class BaseCustomAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected OnItemSelectedListener listener;

    public BaseCustomAdapter(OnItemSelectedListener listener) {
        this.listener = listener;
    }

}
