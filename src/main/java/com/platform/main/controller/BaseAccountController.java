package com.platform.main.controller;

import com.platform.code.util.StringUtils;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.bo.User;
import com.platform.main.bean.po.BaseAccount;
import com.platform.main.service.BaseAccountService;
import com.platform.main.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin/base/baseAccount")
public class BaseAccountController extends BaseController<BaseAccount> {

    @Resource
    private BaseAccountService baseAccountService;

    @Resource
    private UserService userService;

    @RequestMapping(path = "/selectByPrimaryKey", method = RequestMethod.GET)
    public String selectByPrimaryKey(Long accountId) {
        baseAccountService.selectByPrimaryKey(ajaxResponseBody, accountId);
        request.setAttribute("account", ajaxResponseBody.getResult());
        return "authority/accountUpdate";
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public String insert() {
        baseAccountService.insert(obj);
        return "redirect:/admin/base/baseAccount/selectByPage?pageNum=1&state=1";
    }

    @ResponseBody
    @RequestMapping(path = "/deleteByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody deleteByPrimaryKey(Long accountId) {
        baseAccountService.deleteByPrimaryKey(accountId);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/batchDeleteByPrimaryKey", method = RequestMethod.GET)
    public String batchDeleteByPrimaryKey(Long[] accountIds) {
        baseAccountService.batchDeleteByPrimaryKey(accountIds);
        return "redirect:/admin/base/baseAccount/selectByPage?pageNum=1&state=1";
    }

    @RequestMapping(path = "/updateByPrimaryKey", method = RequestMethod.POST)
    public String updateByPrimaryKey() {
        baseAccountService.updateByPrimaryKey(obj);
        return "redirect:/admin/base/baseAccount/selectByPage?pageNum=1&state=1";
    }

    @RequestMapping(path = "/selectByPage", method = RequestMethod.GET)
    public String selectByPage() {
        baseAccountService.selectByBean(ajaxResponseBody, pageInfo);
        pageInfo = (PageInfo) ajaxResponseBody.getResult();
        request.setAttribute("list", pageInfo.getResult());
        request.setAttribute("pageNum", pageInfo.getPageNum());
        request.setAttribute("total", pageInfo.getTotal());
        if(pageInfo.getTotal() % pageInfo.getPageSize() == 0){
            request.setAttribute("totalPage", pageInfo.getTotal() % pageInfo.getPageSize());
        }else{
            request.setAttribute("totalPage", pageInfo.getTotal() % pageInfo.getPageSize() + 1);
        }
        request.setAttribute("obj", pageInfo.getObj());
        return "authority/accounts";
    }

    @RequestMapping(path = "/loadAccountByUsername", method = RequestMethod.GET)
    public AjaxResponseBody loadAccountByUsername() {
        ajaxResponseBody.setResult(0);
        if (obj != null && StringUtils.isNotEmpty(obj.getLoginName())) {
            User user = userService.loadUserByUsername(obj.getLoginName());
            if (user != null) {
                ajaxResponseBody.setResult(1);
            }
        }
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/updateCurrentAccountRole", method = RequestMethod.POST)
    public AjaxResponseBody updateCurrentAccountRole(Long accountId, Long[] roleIds) {
        baseAccountService.updateCurrentAccountRole(accountId, roleIds);
        return ajaxResponseBody;
    }
}
