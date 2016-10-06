package com.lalosoft.smartcoordinatorlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.components.SmartComponent;

import java.util.ArrayList;
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

    private List<SmartComponent> mSmartComponents;

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

        private List<SmartComponent> smartComponents;

        public Builder(@NonNull Context context) {
            this.context = context;
            this.smartComponents = new ArrayList<>();
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


        public Builder addSmartComponent(SmartComponent smartComponent) {
            smartComponents.add(smartComponent);
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
            smartCoordinatorLayout.mSmartComponents = smartComponents;
            return smartCoordinatorLayout;
        }
    }

    public void setup() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_main, rootView);
        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);

        // build smart components
        for (SmartComponent smartComponent : mSmartComponents) {
            smartComponent.setup(mContext, mCoordinatorLayout);
        }
    }

}
