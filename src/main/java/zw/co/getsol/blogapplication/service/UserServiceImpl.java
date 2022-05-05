package zw.co.getsol.blogapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zw.co.getsol.blogapplication.domain.Role;
import zw.co.getsol.blogapplication.domain.User;
import zw.co.getsol.blogapplication.domain.UserRole;
import zw.co.getsol.blogapplication.dto.UserDto;
import zw.co.getsol.blogapplication.exceptions.ItemAlreadyExistException;
import zw.co.getsol.blogapplication.exceptions.RecordNotFoundException;
import zw.co.getsol.blogapplication.persistence.RoleRepository;
import zw.co.getsol.blogapplication.persistence.UserRepository;
import zw.co.getsol.blogapplication.persistence.UserRoleRepository;
import zw.co.getsol.blogapplication.request.SignUpRequest;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RecordNotFoundException("User with id {0} not found"));
        return new UserDto(user);
    }

    @Override
    public UserDto create(SignUpRequest signUpRequest) {
       // Optional<User> user = userRepository.findByUsernameOrEmail(signUpRequest,)
        Role role = roleRepository.findByName("USER")
                .orElseThrow(()-> new RecordNotFoundException("Role does not exist !"));

        User user = new User();
        user.setDateCreated(LocalDateTime.now());
        user.setDateModified(LocalDateTime.now());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastname(signUpRequest.getLastname());
        user.setUsername(signUpRequest.getUsername());
        userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setDateCreated(LocalDateTime.now());
        userRole.setDateModified(LocalDateTime.now());
        userRoleRepository.save(userRole);
        return new UserDto(user);
    }

}
