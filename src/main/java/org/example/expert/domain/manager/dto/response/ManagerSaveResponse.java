package org.example.expert.domain.manager.dto.response;

import lombok.Getter;

import org.example.expert.domain.manager.entity.Manager;
import org.example.expert.domain.user.dto.response.UserResponse;

@Getter
public class ManagerSaveResponse {

    private final Long id;
    private final UserResponse user;

    public ManagerSaveResponse(Long id, UserResponse user) {
        this.id = id;
        this.user = user;
    }

    public static ManagerSaveResponse of(Manager manager) {
        return new ManagerSaveResponse(
            manager.getId(),
            UserResponse.of(manager.getUser()));
    }
}
