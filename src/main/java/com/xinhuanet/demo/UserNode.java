package com.xinhuanet.demo;

import java.util.List;

/**
 * Created by conanca on 15-3-30.
 */
public class UserNode  {
    private Long id;
    private Integer userId;
    private List<String> customFriendGroups;
    private Long createdAt;
    private Long updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<String> getCustomFriendGroups() {
        return customFriendGroups;
    }

    public void setCustomFriendGroups(List<String> customFriendGroups) {
        this.customFriendGroups = customFriendGroups;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}