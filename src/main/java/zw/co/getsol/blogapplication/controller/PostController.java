package zw.co.getsol.blogapplication.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zw.co.getsol.blogapplication.dto.PostDto;
import zw.co.getsol.blogapplication.request.PostRequest;
import zw.co.getsol.blogapplication.request.PostUpdateRequest;
import zw.co.getsol.blogapplication.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts/")
@RequiredArgsConstructor
@Tag(name = "Post Controller",description = "Post Endpoints")
public class PostController {
    private final  PostService postService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("create")
    public ResponseEntity<PostDto> create(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.create(postRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest){
        return ResponseEntity.ok(postService.update(id,postUpdateRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
       postService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Page<PostDto>> getAllPost(
            @RequestParam(name = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize
            ){
        return ResponseEntity.ok(postService.getAllPosts(pageNo,pageSize));
    }
}
