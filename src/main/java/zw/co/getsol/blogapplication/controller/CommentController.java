package zw.co.getsol.blogapplication.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.getsol.blogapplication.dto.CommentDto;
import zw.co.getsol.blogapplication.request.CommentRequest;
import zw.co.getsol.blogapplication.request.CommentUpdateRequest;
import zw.co.getsol.blogapplication.service.CommentService;

@RestController
@RequestMapping("/api/comments/")
@RequiredArgsConstructor
@Tag(name = "Comments Controller",description = "Comments Endpoints")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity create(@RequestBody CommentRequest commentRequest){
        return ResponseEntity.ok(commentService.create(commentRequest));
    }
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> update(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        return ResponseEntity.ok(commentService.edit(commentId,commentUpdateRequest));
    }
    @GetMapping("/{postId}")
    public ResponseEntity<Page<CommentDto>> findByPostId(@PathVariable Long postId,
                                                         @RequestParam(defaultValue ="0",required = false)int pageNo,
                                                         @RequestParam(defaultValue = "20",required = false) int pageSize){
        return ResponseEntity.ok(commentService.findByPostId(postId,pageNo,pageSize));
    }
    @DeleteMapping("/{commentId}")
    public void delete(@PathVariable Long commentId){
        commentService.delete(commentId);
    }
}
