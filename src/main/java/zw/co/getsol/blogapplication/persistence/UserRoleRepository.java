package zw.co.getsol.blogapplication.persistence;

import org.springframework.stereotype.Repository;
import zw.co.getsol.blogapplication.domain.Role;
import zw.co.getsol.blogapplication.domain.User;
import zw.co.getsol.blogapplication.domain.UserRole;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends BaseRepository<UserRole> {
   List<UserRole> findAllByUser(User user);
}
