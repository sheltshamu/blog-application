package zw.co.getsol.blogapplication.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.getsol.blogapplication.domain.User;

@Getter
@Setter
public class UserDto {
    private String firstname;
    private String lastname;
    private String email;

    public UserDto(User user) {
        this.firstname=user.getFirstName();
        this.lastname= user.getLastname();
        this.email= user.getEmail();
    }
}
