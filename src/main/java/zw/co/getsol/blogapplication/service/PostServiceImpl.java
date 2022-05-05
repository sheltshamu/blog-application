package zw.co.getsol.blogapplication.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import zw.co.getsol.blogapplication.domain.Post;
import zw.co.getsol.blogapplication.dto.PostDto;
import zw.co.getsol.blogapplication.exceptions.RecordNotFoundException;
import zw.co.getsol.blogapplication.persistence.PostRepository;
import zw.co.getsol.blogapplication.request.PostRequest;
import zw.co.getsol.blogapplication.request.PostUpdateRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto create(PostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setDescription(postRequest.getDescription());
        post.setDateModified(LocalDateTime.now());
        post.setDateCreated(LocalDateTime.now());
        postRepository.save(post);
        return new PostDto(post);
    }

    @Override
    public PostDto update(Long id,PostUpdateRequest postUpdateRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException("Post {0} not found",id));
        post.setTitle(postUpdateRequest.getTitle());
        post.setDescription(postUpdateRequest.getDescription());
        post.setContent(postUpdateRequest.getContent());
        post.setDateModified(LocalDateTime.now());
        postRepository.save(post);
        return new PostDto(post);
    }

    @Override
    public void delete(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RecordNotFoundException("Post {0} not found",postId));
        postRepository.delete(post);
    }

    @Override
    public Page<PostDto> getAllPosts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> postPage = postRepository.findAll(pageable);
        return postPage.map(
                post -> {
                    PostDto postDto = new PostDto(post);
                    return postDto;
                }
        );
    }

}
