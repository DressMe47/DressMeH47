package com.whoame.dressme.List.ExpandableRecyclerView;

import android.view.View;

/**
 * Created by oprv2 on 02.06.2017.
 */

public interface OnChildClickListener {
    /**
     * Callback method to be invoked when a child in this expandable list has
     * been clicked.
     *
     * @param v The view within the expandable list/ListView that was clicked
     * @param groupPosition The group position that contains the child that
     *        was clicked
     * @param childPosition The child position within the group
     * @param id The row id of the child that was clicked
     * @return True if the click was handled
     */
    boolean onChildClick(View v, int groupPosition, int childPosition, long id);
}
