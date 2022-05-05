package zw.co.getsol.blogapplication.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.getsol.blogapplication.dto.PostDto;
import zw.co.getsol.blogapplication.request.PostRequest;
import zw.co.getsol.blogapplication.request.PostUpdateRequest;

import java.util.List;

public interface PostService {
    PostDto create(PostRequest postRequest);
    PostDto update(Long id,PostUpdateRequest postUpdateRequest);
    void delete(Long postId);
    Page<PostDto> getAllPosts(int pageNo, int pageSize);
}
