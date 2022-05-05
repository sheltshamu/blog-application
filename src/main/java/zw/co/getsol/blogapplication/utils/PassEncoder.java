package zw.co.getsol.blogapplication.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PassEncoder {
    public static void main(String[] args) {
        PasswordEncoder p = new BCryptPasswordEncoder();
        System.out.println(p.encode(""));
    }
}
