package com.zhihuishu.athomework.dto;

import java.io.Serializable;

public class CommonUserRmiDto implements Serializable {

    private static final long serialVersionUID = 4822541342850712592L;

    // 用户ID
    private Long userId;

    // 头像
    private String avatar;

    // 真实姓名
    private String realname;

    // 用户名
    private String username;

    // 性别
    private Integer gender;

    // 手机号
    private String mobile;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
