package com.lalosoft.smartcoordinatorlayout.demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gonzalo.Martin on 10/6/2016
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView text;

    public CustomViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.item_text);
    }
}
