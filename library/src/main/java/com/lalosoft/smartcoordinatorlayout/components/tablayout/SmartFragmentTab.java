package com.lalosoft.smartcoordinatorlayout.components.tablayout;

import android.support.v4.app.Fragment;

/**
 * Created by Gonzalo.Martin on 10/11/2016
 */

public class SmartFragmentTab {

    private String title;
    private Fragment content;

    public SmartFragmentTab(String title, Fragment content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public Fragment getContent() {
        return content;
    }
}
