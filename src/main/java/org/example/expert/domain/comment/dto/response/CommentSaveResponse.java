package org.example.expert.domain.comment.dto.response;

import lombok.Getter;

import org.example.expert.domain.comment.entity.Comment;
import org.example.expert.domain.user.dto.response.UserResponse;

@Getter
public class CommentSaveResponse {

    private final Long id;
    private final String contents;
    private final UserResponse user;

    public CommentSaveResponse(Long id, String contents, UserResponse user) {
        this.id = id;
        this.contents = contents;
        this.user = user;
    }

    public static CommentSaveResponse of(Comment comment) {
        return new CommentSaveResponse(
            comment.getId(),
            comment.getContents(),
            UserResponse.of(comment.getUser()));
    }
}
