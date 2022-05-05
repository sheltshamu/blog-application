package zw.co.getsol.blogapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import zw.co.getsol.blogapplication.dto.RoleDto;
import zw.co.getsol.blogapplication.dto.UserDto;
import zw.co.getsol.blogapplication.request.LoginRequest;
import zw.co.getsol.blogapplication.request.RoleRequest;
import zw.co.getsol.blogapplication.request.SignUpRequest;
import zw.co.getsol.blogapplication.service.RoleService;
import zw.co.getsol.blogapplication.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserService userService, RoleService roleService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.roleService = roleService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("User signed-in successfully !..");
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> userSignUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(userService.create(signUpRequest));
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody RoleRequest roleRequest){
        return ResponseEntity.ok(roleService.create(roleRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}
