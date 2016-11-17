package com.lalosoft.smartcoordinatorlayout.components.tablayout;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.lalosoft.smartcoordinatorlayout.R;
import com.lalosoft.smartcoordinatorlayout.components.BaseSmartComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo.Martin on 10/11/2016
 */

public class SmartFragmentTabLayout extends BaseSmartComponent {

    private FragmentManager fm;
    private List<SmartFragmentTab> tabs;
    private FrameLayout frameLayout;

    /**
     * Constructor of SmartFragmentTabLayout
     * @param fragmentManager {@link FragmentManager}
     */
    public SmartFragmentTabLayout(FragmentManager fragmentManager) {
        this.tabs = new ArrayList<>();
        this.fm = fragmentManager;
    }

    @Override
    public View setup(Context context, ViewGroup viewGroup) {
        this.mContext = context;

        if (tabs.isEmpty()) {
            throw new IllegalStateException("You must add one tab at least");
        }

        // setup parent linear layout
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // setup tab layout
        TabLayout tabLayout = new TabLayout(context);
        tabLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // build view pager
        ViewPager viewPager = new ViewPager(context);
        viewPager.setId(R.id.viewpager);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
        viewPager.setLayoutParams(layoutParams);
        viewPager.setOffscreenPageLimit(tabs.size());
        viewPager.setAdapter(new SmartFragmentPagerAdapter(fm));
        tabLayout.setupWithViewPager(viewPager);

        // add components to parent view
        linearLayout.addView(tabLayout);
        linearLayout.addView(viewPager);

        return linearLayout;
    }

    /**
     * Adds a new {@link SmartFragmentTab} to {@link TabLayout}
     * @param smartFragmentTab
     */
    public void addTab(SmartFragmentTab smartFragmentTab) {
        tabs.add(smartFragmentTab);
    }

    private class SmartFragmentPagerAdapter extends FragmentPagerAdapter {

        public SmartFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabs.get(position).getContent();
        }

        @Override
        public int getCount() {
            return tabs.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position).getTitle();
        }
    }
}
