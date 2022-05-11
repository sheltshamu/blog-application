package zw.co.getsol.blogapplication.dto;

import lombok.Getter;
import zw.co.getsol.blogapplication.domain.Comment;

@Getter
public final class CommentDto {
    private String name;
    private String email;
    private String body;
    private Long postId;

    public CommentDto(Comment comment) {
        this.name = comment.getName();
        this.email=comment.getEmail();
        this.body= comment.getBody();
        this.postId=comment.getPost().getId();
    }
}
