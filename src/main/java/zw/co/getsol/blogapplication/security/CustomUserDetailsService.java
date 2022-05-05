package zw.co.getsol.blogapplication.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zw.co.getsol.blogapplication.domain.Role;
import zw.co.getsol.blogapplication.domain.User;
import zw.co.getsol.blogapplication.domain.UserRole;
import zw.co.getsol.blogapplication.exceptions.RecordNotFoundException;
import zw.co.getsol.blogapplication.persistence.UserRoleRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRoleRepository userRoleRepository;

    public CustomUserDetailsService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserRole> userRole = Optional.ofNullable(userRoleRepository.findByUserUsername(username));
        if (!userRole.isPresent()){
            throw new RecordNotFoundException("Username {0} not found");
        }
        User user = userRole.get().getUser();
        List<Role> roles = new ArrayList<>();
        roles.add(userRole.get().getRole());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(roles));

    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
