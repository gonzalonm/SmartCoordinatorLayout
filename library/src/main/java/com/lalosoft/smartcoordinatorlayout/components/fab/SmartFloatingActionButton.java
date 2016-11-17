package com.lalosoft.smartcoordinatorlayout.components.fab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.R;
import com.lalosoft.smartcoordinatorlayout.components.BaseSmartComponent;
import com.lalosoft.smartcoordinatorlayout.components.SmartComponent;

/**
 * Created by Gonzalo.Martin on 10/6/2016
 */

public class SmartFloatingActionButton extends BaseSmartComponent implements SmartComponent {

    private static final FABPosition DEFAULT_FAB_POSITION = FABPosition.BOTTOM_RIGHT;
    private static final FABType DEFAULT_FAB_TYPE = FABType.ADD;

    private final FABType mFabType;
    private final FloatingActionButtonListener mListener;
    private final FABPosition mFabPosition;
    private Drawable mCustomDrawableFABIcon = null;

    /**
     * Used for Floating Action Button icon type
     */
    public enum FABType {
        ADD, EDIT
    }

    /**
     * Used for Floating Action Button position
     */
    public enum FABPosition {
        BOTTOM_RIGHT, BOTTOM_LEFT, TOP_RIGHT, TOP_LEFT
    }

    /**
     * Listener for Floating Action Button
     */
    public interface FloatingActionButtonListener {
        void onFABPressed();
    }

    /**
     * Constructor of SmartFloatingActionButton
     * @param fabType the type of FAB (use {@link FABType})
     * @param fabPosition the position of FAB in the screen (use {@link FABPosition}
     * @param listener the listener for the button
     */
    public SmartFloatingActionButton(FABType fabType, FABPosition fabPosition, FloatingActionButtonListener listener) {
        this.mFabType = fabType;
        this.mFabPosition = fabPosition;
        this.mListener = listener;
    }

    /**
     * Constructor of SmartFloatingActionButton
     * @param fabType the type of FAB (use {@link FABPosition})
     * @param listener the listener for the button
     */
    public SmartFloatingActionButton(FABType fabType, FloatingActionButtonListener listener) {
        this(fabType, DEFAULT_FAB_POSITION, listener);
    }

    /**
     * Constructor of SmartFloatingActionButton
     * * Using default {@link FABType}
     * @param fabPosition the position of FAB in the screen (use {@link FABPosition}
     * @param listener the listener for the button
     */
    public SmartFloatingActionButton(FABPosition fabPosition, FloatingActionButtonListener listener) {
        this(DEFAULT_FAB_TYPE, fabPosition, listener);
    }

    /**
     * Constructor of SmartFloatingActionButton
     * * Using default {@link FABPosition}
     * @param customDrawableFABIcon {@link Drawable} instance of the icon
     * @param listener the listener for the button
     */
    public SmartFloatingActionButton(Drawable customDrawableFABIcon, FloatingActionButtonListener listener) {
        this(null, DEFAULT_FAB_POSITION, listener);
        mCustomDrawableFABIcon = customDrawableFABIcon;
    }

    /**
     * Constructor of SmartFloatingActionButton
     * Using default {@link FABType} and {@link FABPosition}
     * @param listener the listener for the button
     */
    public SmartFloatingActionButton(FloatingActionButtonListener listener) {
        this(DEFAULT_FAB_TYPE, DEFAULT_FAB_POSITION, listener);
    }

    @Override
    public View setup(Context context, ViewGroup viewGroup) {
        mContext = context;

        // find view by id
        FloatingActionButton fab = new FloatingActionButton(context);

        // check for custom fab icon
        if (mCustomDrawableFABIcon == null) {
            // set icon
            applyFabIcon(fab);
        } else {
            // set custom icon
            fab.setImageDrawable(mCustomDrawableFABIcon);
        }

        // set layout params
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setAnchorId(View.NO_ID);
        lp.gravity = resolveGravity(mFabPosition);
        fab.setLayoutParams(lp);

        // set floating action button listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFABPressed();
            }
        });

        return fab;
    }

    /**
     * Resolves the gravity based on {@link FABPosition} provided
     * @param position of the button. Use {@link FABPosition}
     * @return the computed gravity
     */
    private int resolveGravity(FABPosition position) {
        switch (position) {
            case BOTTOM_RIGHT:
                return Gravity.BOTTOM | GravityCompat.END;
            case TOP_RIGHT:
                return Gravity.TOP | GravityCompat.END;
            case BOTTOM_LEFT:
                return Gravity.BOTTOM | GravityCompat.START;
            case TOP_LEFT:
                return Gravity.TOP | GravityCompat.START;
            default:
                return 0;
        }
    }

    /**
     *  Add the FAB icon based on {@link FABType}
     * @param fab an instance of {@link FloatingActionButton}
     */
    private void applyFabIcon(FloatingActionButton fab) {
        switch (mFabType) {
            case ADD:
                fab.setImageResource(R.drawable.ic_add_white_24dp);
                break;
            case EDIT:
                fab.setImageResource(R.drawable.ic_content_create);
                break;
        }
    }


}
