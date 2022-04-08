package com.bs.grad.domain;

import java.util.Date;

public class UserWeight {
    private int id;
    private String user_name;
    private Date time;
    private int t_weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getT_weight() {
        return t_weight;
    }

    public void setT_weight(int t_weight) {
        this.t_weight = t_weight;
    }
}
