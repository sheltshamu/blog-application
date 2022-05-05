package zw.co.getsol.blogapplication.persistence;

import org.springframework.stereotype.Repository;
import zw.co.getsol.blogapplication.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User>{
    Optional<User> findByUsernameOrEmail(String username,String email);
}
