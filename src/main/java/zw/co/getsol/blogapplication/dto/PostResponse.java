package zw.co.getsol.blogapplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponse {
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private int totalNumberOfElements;
    private int totalNumberOfPages;
}
