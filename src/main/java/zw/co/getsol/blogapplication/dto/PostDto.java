package zw.co.getsol.blogapplication.dto;

import lombok.Getter;
import zw.co.getsol.blogapplication.domain.Post;

@Getter
public class PostDto {
    private String title;
    private String description;
    private String content;
    public PostDto(Post post) {
        this.title=post.getTitle();
        this.description= post.getDescription();
        this.content=post.getContent();
    }


}
