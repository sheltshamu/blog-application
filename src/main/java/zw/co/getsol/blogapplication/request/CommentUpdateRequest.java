package zw.co.getsol.blogapplication.request;

import lombok.Getter;

@Getter
public class CommentUpdateRequest {
    private String name;
    private String email;
    private String body;
    private Long postId;
}
