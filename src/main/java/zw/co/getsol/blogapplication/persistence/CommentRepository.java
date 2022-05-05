package zw.co.getsol.blogapplication.persistence;

import org.springframework.stereotype.Repository;
import zw.co.getsol.blogapplication.domain.Comment;

@Repository
public interface CommentRepository extends BaseRepository<Comment> {
}
