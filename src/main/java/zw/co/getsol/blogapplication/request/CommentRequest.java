package zw.co.getsol.blogapplication.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CommentRequest {
    @NotBlank(message = "name is required")
    private String name;
    private String email;
    private String body;
    private Long postId;
}
