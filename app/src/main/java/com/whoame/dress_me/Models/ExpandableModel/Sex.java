package com.whoame.dress_me.Models.ExpandableModel;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

/**
 * Created by oprv2 on 31.05.2017.
 */

public class Sex implements Parent<Categories> {
    private String title;
    private List<Categories> childrenList;

    public Sex(String title, List<Categories> categories) {
        this.title = title;
        childrenList = categories;
    }

    @Override
    public List<Categories> getChildList() {
        return childrenList;
    }

    public String getTitle() {
        return title;
    }

    public Categories getSex(int position) {
        return childrenList.get(position);
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
