package com.platform.main.bean.bo;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
    private Long menuId;

    private String title;

    private String path;

    private String menuIconClass;

    private List<MenuInfo> children = new ArrayList<>();

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMenuIconClass() {
        return menuIconClass;
    }

    public void setMenuIconClass(String menuIconClass) {
        this.menuIconClass = menuIconClass;
    }

    public List<MenuInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInfo> children) {
        this.children = children;
    }
}
