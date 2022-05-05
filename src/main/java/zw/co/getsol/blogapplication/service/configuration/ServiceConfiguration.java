package zw.co.getsol.blogapplication.service.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import zw.co.getsol.blogapplication.persistence.CommentRepository;
import zw.co.getsol.blogapplication.persistence.PostRepository;
import zw.co.getsol.blogapplication.persistence.RoleRepository;
import zw.co.getsol.blogapplication.service.*;

@Configuration
@RequiredArgsConstructor
public class ServiceConfiguration {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    private final RoleRepository roleRepository;

    @Bean
    public CommentService commentService(){
        return new CommentServiceImpl(commentRepository,postRepository);
    }

    @Bean
    public PostService postService(){
        return new PostServiceImpl(postRepository);
    }

    @Bean
    public RoleService roleService(){
        return new RoleServiceImpl(roleRepository);
    }

}
