package com.lalosoft.smartcoordinatorlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

/**
 * Created by Gonzalo.Martin on 9/30/2016
 */

public class SmartCoordinatorLayout {

    CoordinatorLayout mCoordinatorLayout;

    // Vars from Builder
    private Context mContext;
    private FloatingActionButtonListener mFloatingActionButtonListener;
    private View mView;
    private FABType mFabType;

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
        private View view;
        private FABType fabType;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder buildWithView(@NonNull View view) {
            this.view = view;
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

        public SmartCoordinatorLayout build() {
            SmartCoordinatorLayout smartCoordinatorLayout = new SmartCoordinatorLayout();
            smartCoordinatorLayout.mContext = this.context;
            smartCoordinatorLayout.mFabType = fabType;
            smartCoordinatorLayout.mFloatingActionButtonListener = floatingActionButtonListener;
            smartCoordinatorLayout.mView = view;
            return smartCoordinatorLayout;
        }
    }

    public void setup() {
        // TODO: implement the setup of this control
    }
}
