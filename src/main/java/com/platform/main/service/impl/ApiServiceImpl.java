package com.platform.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseApi;
import com.platform.main.dao.ApiMapper;
import com.platform.main.service.ApiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl extends BaseService implements ApiService {

    @Resource
    private ApiMapper baseApiMapper;

    @Override
    public List<BaseApi> selectApiListByRoleSign(String roleSign) {
        List<BaseApi> baseApiList = baseApiMapper.selectApiListByRoleSign(roleSign);
        return baseApiList;
    }

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseApi> pageInfo) {
        if (pageInfo != null) {
            Page<BaseApi> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            baseApiMapper.selectByBean(pageInfo.getObj());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setResult(page.getResult());
            ajaxResponseBody.setResult(pageInfo);
        }
        return ajaxResponseBody;
    }

    @Override
    public AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long apiId) {
        if (apiId != null) {
            BaseApi baseApi = baseApiMapper.selectByPrimaryKey(apiId);
            ajaxResponseBody.setResult(baseApi);
        }
        return ajaxResponseBody;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void batchDeleteByPrimaryKey(Long[] apiIds) {
        if (apiIds != null && apiIds.length > 0) {
            List list = Arrays.asList(apiIds);
            baseApiMapper.batchDeleteByPrimaryKey(list);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void deleteByPrimaryKey(Long apiId) {
        if (apiId != null && apiId > 0) {
            baseApiMapper.deleteByPrimaryKey(apiId);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void insert(BaseApi baseApi) {
        if (baseApi != null) {
            baseApiMapper.insert(baseApi);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void updateByPrimaryKey(BaseApi baseApi) {
        if (baseApi != null && baseApi.getApiId() != null) {
            baseApiMapper.updateByPrimaryKey(baseApi);
        }
    }
}
