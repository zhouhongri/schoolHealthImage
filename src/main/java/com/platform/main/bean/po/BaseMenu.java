package com.platform.main.bean.po;

import java.io.Serializable;

public class BaseMenu implements Serializable {

    private static final long serialVersionUID = 4125094236372084319L;

    private Long menuId;

    private String menuUrl;

    private String menuPath;

    private String menuComponent;

    private String menuName;

    private String menuIconClass;

    private Integer keepAlive;

    private Integer requireAuth;

    private Long parentMenuId;

    private Integer enabled;


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuComponent() {
        return menuComponent;
    }

    public void setMenuComponent(String menuComponent) {
        this.menuComponent = menuComponent;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIconClass() {
        return menuIconClass;
    }

    public void setMenuIconClass(String menuIconClass) {
        this.menuIconClass = menuIconClass;
    }

    public Integer getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Integer keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Integer getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Integer requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Long getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
