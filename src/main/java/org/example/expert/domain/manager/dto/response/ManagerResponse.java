package org.example.expert.domain.manager.dto.response;

import lombok.Getter;

import org.example.expert.domain.comment.dto.response.CommentResponse;
import org.example.expert.domain.comment.entity.Comment;
import org.example.expert.domain.manager.entity.Manager;
import org.example.expert.domain.user.dto.response.UserResponse;

@Getter
public class ManagerResponse {

    private final Long id;
    private final UserResponse user;

    public ManagerResponse(Long id, UserResponse user) {
        this.id = id;
        this.user = user;
    }

    public static ManagerResponse of(Manager manager) {
        return new ManagerResponse(
            manager.getId(),
            UserResponse.of(manager.getUser()));
    }
}
