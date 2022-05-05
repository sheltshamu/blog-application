package zw.co.getsol.blogapplication.service;

import zw.co.getsol.blogapplication.dto.UserDto;
import zw.co.getsol.blogapplication.request.SignUpRequest;

public interface UserService {
    UserDto findById(Long userId);

    UserDto create(SignUpRequest signUpRequest);
}
