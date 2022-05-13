package zw.co.getsol.blogapplication.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import zw.co.getsol.blogapplication.domain.Comment;

@Repository
public interface CommentRepository extends BaseRepository<Comment> {
    Page<Comment> findAllByPostId(Long postId, Pageable pageable);
}
