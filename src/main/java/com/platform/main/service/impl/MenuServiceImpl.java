package com.platform.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.code.util.ErrorCode;
import com.platform.code.util.StringUtils;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.MenuInfo;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.bo.User;
import com.platform.main.bean.po.BaseMenu;
import com.platform.main.bean.po.BaseRole;
import com.platform.main.dao.MenuMapper;
import com.platform.main.dao.RoleMapper;
import com.platform.main.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseService implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public AjaxResponseBody selectMenuInfo(AjaxResponseBody ajaxResponseBody) {
        if (StringUtils.isEmpty(ajaxResponseBody.getJwtToken())) {
            ajaxResponseBody.setMsg(ErrorCode.PARAM_NULL_ERROR.getName());
            ajaxResponseBody.setStatus(ErrorCode.PARAM_NULL_ERROR.getStatusCode());
        }
        // TODO 从session获取User
        String username = "";
        User user = userService.loadUserByUsername(username);

        List<BaseRole> baseRoles = roleMapper.selectByAccountId(user.getAccountId());
        List<MenuInfo> menuInfos = new ArrayList<>();
        for (BaseRole baseRole : baseRoles) {
            List<MenuInfo> menuInfosEveryRole = new ArrayList<>();
            if (baseRole != null && StringUtils.isNotEmpty(baseRole.getRoleSign())) {
                    List<BaseMenu> baseMenus = menuMapper.selectMenuListByRoleSign(baseRole.getRoleSign());
                    Iterator<BaseMenu> iterator = baseMenus.iterator();
                    while (iterator.hasNext()) {
                        BaseMenu baseMenu = iterator.next();
                        if (baseMenu.getParentMenuId() == 0) {
                            // 先找到所有的一级菜单、父ID为0
                            boolean flag = true;
                            for (MenuInfo menuInfo : menuInfos) {
                                if (menuInfo.getMenuId().equals(baseMenu.getMenuId())) {
                                    // 如果多个角色的菜单一样 父ID不重复加入menuInfosEveryRole
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                menuInfosEveryRole.add(initMenuInfo(baseMenu));
                            }
                        }
                    }

                    // 为一级菜单设置子菜单，getChild是递归调用的
                    for (MenuInfo menu : menuInfosEveryRole) {
                        menu.setChildren(getChild(menu.getMenuId(), baseMenus));
                    }

                    // 返回该账号所有菜单列表
                    menuInfos.addAll(menuInfosEveryRole);
                }
            }

        ajaxResponseBody.setResult(menuInfos);
        return ajaxResponseBody;
    }

    /**
     * 子菜单递归
     *
     * @param menuId
     * @param rootMenu
     * @return
     */
    private List<MenuInfo> getChild(Long menuId, List<BaseMenu> rootMenu) {
        // 子菜单
        List<MenuInfo> childList = new ArrayList<>();
        Iterator<BaseMenu> iterator = rootMenu.iterator();
        while (iterator.hasNext()) {
            BaseMenu menu = iterator.next();
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menuId.equals(menu.getParentMenuId())) {
                childList.add(initMenuInfo(menu));
                iterator.remove();
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (MenuInfo menu : childList) {
            menu.setChildren(getChild(menu.getMenuId(), rootMenu));// 递归
        }

        // 判断递归结束
        if (childList.size() == 0) {
            return new ArrayList<>();
        }
        return childList;
    }

    /**
     * MenuInfo初始化
     */
    private MenuInfo initMenuInfo(BaseMenu menu) {
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setMenuId(menu.getMenuId());
        menuInfo.setTitle(menu.getMenuName());
        menuInfo.setPath(menu.getMenuPath());
        menuInfo.setMenuIconClass(menu.getMenuIconClass());
        return menuInfo;
    }

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseMenu> pageInfo) {
        if (pageInfo != null) {
            Page<BaseMenu> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            menuMapper.selectByBean(pageInfo.getObj());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setResult(page.getResult());
            ajaxResponseBody.setResult(pageInfo);
        }
        return ajaxResponseBody;
    }

    @Override
    public AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long menuId) {
        if (menuId != null) {
            BaseMenu baseMenu = menuMapper.selectByPrimaryKey(menuId);
            ajaxResponseBody.setResult(baseMenu);
        }
        return ajaxResponseBody;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void batchDeleteByPrimaryKey(Long[] menuIds) {
        if (menuIds != null && menuIds.length > 0) {
            List list = Arrays.asList(menuIds);
            menuMapper.batchDeleteByPrimaryKey(list);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void deleteByPrimaryKey(Long menuId) {
        if (menuId != null && menuId > 0) {
            menuMapper.deleteByPrimaryKey(menuId);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void insert(BaseMenu baseMenu) {
        if (baseMenu != null) {
            menuMapper.insert(baseMenu);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void updateByPrimaryKey(BaseMenu baseMenu) {
        if (baseMenu != null && baseMenu.getMenuId() != null) {
            menuMapper.updateByPrimaryKey(baseMenu);
        }
    }

    /**
     * 查询所有菜单列表
     *
     * @param ajaxResponseBody
     * @return
     */
    @Override
    public AjaxResponseBody selectAllMenuInfo(AjaxResponseBody ajaxResponseBody) {
        List<MenuInfo> menuInfos = new ArrayList<>();
        List<BaseMenu> baseMenus = menuMapper.selectByBean(new BaseMenu());
        Iterator<BaseMenu> iterator = baseMenus.iterator();
        while (iterator.hasNext()) {
            BaseMenu baseMenu = iterator.next();
            if (baseMenu.getParentMenuId() == 0) {
                // 先找到所有的一级菜单、父ID为0
                menuInfos.add(initMenuInfo(baseMenu));
                iterator.remove();
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (MenuInfo menu : menuInfos) {
            menu.setChildren(getChild(menu.getMenuId(), baseMenus));
        }

        ajaxResponseBody.setResult(menuInfos);
        return ajaxResponseBody;
    }

    /**
     * 根据角色标志查询菜单
     *
     * @return
     */
    @Override
    public AjaxResponseBody selectMenuChildListByRoleSign(AjaxResponseBody ajaxResponseBody, String roleSign) {
        if (StringUtils.isNotEmpty(roleSign)) {
            ajaxResponseBody.setResult(menuMapper.selectMenuChildListByRoleSign(roleSign));
        }
        return ajaxResponseBody;
    }
}
