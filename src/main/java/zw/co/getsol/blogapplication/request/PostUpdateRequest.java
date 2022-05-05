package zw.co.getsol.blogapplication.request;

import lombok.Getter;

@Getter
public class PostUpdateRequest {
    private String title;
    private String description;
    private String content;
}
