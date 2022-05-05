package zw.co.getsol.blogapplication.service;

import zw.co.getsol.blogapplication.dto.CommentDto;
import zw.co.getsol.blogapplication.request.CommentRequest;
import zw.co.getsol.blogapplication.request.CommentUpdateRequest;

public interface CommentService {
    CommentDto create(CommentRequest commentRequest);
    CommentDto edit(Long id,CommentUpdateRequest commentUpdateRequest);
    void delete(Long commentId);

}
