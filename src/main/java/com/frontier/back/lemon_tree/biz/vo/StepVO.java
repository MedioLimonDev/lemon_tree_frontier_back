package com.frontier.back.lemon_tree.biz.vo;

import java.util.List;

public class StepVO extends ModelVO{
    private String title;

    private String description;

    private String agentActivity;

    private String customerActivity;

    private List<ResponseVO> responseList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgentActivity() {
        return agentActivity;
    }

    public void setAgentActivity(String agentActivity) {
        this.agentActivity = agentActivity;
    }

    public String getCustomerActivity() {
        return customerActivity;
    }

    public void setCustomerActivity(String customerActivity) {
        this.customerActivity = customerActivity;
    }

    public List<ResponseVO> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ResponseVO> responseList) {
        this.responseList = responseList;
    }
}
