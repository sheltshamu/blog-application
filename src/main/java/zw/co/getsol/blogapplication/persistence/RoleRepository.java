package zw.co.getsol.blogapplication.persistence;

import org.springframework.stereotype.Repository;
import zw.co.getsol.blogapplication.domain.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role>{
    Optional<Role> findByName(String name);
}
