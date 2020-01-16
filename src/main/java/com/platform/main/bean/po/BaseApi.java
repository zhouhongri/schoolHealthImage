package com.platform.main.bean.po;

import java.io.Serializable;
import java.util.Objects;

public class BaseApi implements Serializable {

    private static final long serialVersionUID = 4125096736372084319L;

    private Long apiId;

    private String apiUrlPatten;

    private String apiName;

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getApiUrlPatten() {
        return apiUrlPatten;
    }

    public void setApiUrlPatten(String apiUrlPatten) {
        this.apiUrlPatten = apiUrlPatten;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseApi baseApi = (BaseApi) o;
        return Objects.equals(apiId, baseApi.apiId) &&
                Objects.equals(apiUrlPatten, baseApi.apiUrlPatten) &&
                Objects.equals(apiName, baseApi.apiName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiId, apiUrlPatten, apiName);
    }
}
