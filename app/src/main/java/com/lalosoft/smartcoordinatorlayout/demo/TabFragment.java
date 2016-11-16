package com.lalosoft.smartcoordinatorlayout.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Gonzalo.Martin on 10/11/2016
 */

public class TabFragment extends Fragment {

    private String text;

    public static TabFragment newInstance(String text) {
        TabFragment tabFragment = new TabFragment();
        tabFragment.setText(text);
        return tabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.text)).setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
