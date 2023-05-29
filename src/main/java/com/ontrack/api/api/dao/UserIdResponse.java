package com.ontrack.api.api.dao;

public class UserIdResponse {
    private Long id;

    public UserIdResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
