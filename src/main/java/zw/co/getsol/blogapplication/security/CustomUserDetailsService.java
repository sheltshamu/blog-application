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
import zw.co.getsol.blogapplication.persistence.UserRepository;
import zw.co.getsol.blogapplication.persistence.UserRoleRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(()-> new RecordNotFoundException("User {0} not found"));
        List<UserRole> roles = userRoleRepository.findAllByUser(user);
        List<Role> roleList = new ArrayList<>();
        roles.stream().map(userRole -> roleList.add(userRole.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(roleList));

    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
