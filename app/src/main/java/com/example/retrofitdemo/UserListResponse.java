package com.example.retrofitdemo;


import java.util.HashMap;
import java.util.Map;



public class UserListResponse {

    // POJO class to get the data from web api
    private String name;
    private String realname;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getRealName() {
        return realname;
    }

    public void setRealName(String realname) {
        this.realname = realname;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}