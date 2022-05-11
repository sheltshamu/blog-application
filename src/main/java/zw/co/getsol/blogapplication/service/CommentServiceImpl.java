package zw.co.getsol.blogapplication.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import zw.co.getsol.blogapplication.domain.Comment;
import zw.co.getsol.blogapplication.dto.CommentDto;
import zw.co.getsol.blogapplication.exceptions.RecordNotFoundException;
import zw.co.getsol.blogapplication.persistence.CommentRepository;
import zw.co.getsol.blogapplication.persistence.PostRepository;
import zw.co.getsol.blogapplication.request.CommentRequest;
import zw.co.getsol.blogapplication.request.CommentUpdateRequest;

import java.time.LocalDateTime;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto create(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setBody(commentRequest.getBody());
        comment.setEmail(commentRequest.getEmail());
        comment.setName(commentRequest.getName());
        comment.setDateCreated(LocalDateTime.now());
        comment.setDateModified(LocalDateTime.now());
        commentRepository.save(comment);
        return new CommentDto(comment);
    }

    @Override
    public CommentDto edit(Long id, CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Comment {0} not found"));
        comment.setName(commentUpdateRequest.getName());
        comment.setBody(commentUpdateRequest.getBody());
        comment.setEmail(commentUpdateRequest.getEmail());
        commentRepository.save(comment);
        return new CommentDto(comment);
    }

    @Override
    public void delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RecordNotFoundException("Comment {0} not found"));
        commentRepository.delete(comment);
    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Comment> comments = commentRepository.findAllByPostId(postId);
        return comments.map(comment -> {
                    CommentDto commentDto = new CommentDto(comment);
                    return commentDto;
                });
    }
}
