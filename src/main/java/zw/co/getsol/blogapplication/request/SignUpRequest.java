package zw.co.getsol.blogapplication.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String firstName;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
