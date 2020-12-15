package com.frontier.back.lemon_tree.data.entity;

import java.util.List;

public class Step extends Model{
    private String title;

    private String description;

    private String agentActivity;

    private String customerActivity;

    private List<Response> response;

    public Step(int id, String title, String description, String agent_activity, String customer_activity) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.agentActivity = agent_activity;
        this.customerActivity = customer_activity;
    }

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

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }
}
