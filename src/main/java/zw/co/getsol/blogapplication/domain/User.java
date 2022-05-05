package zw.co.getsol.blogapplication.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user",
        uniqueConstraints ={
            @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"email"})
        }
)
public class User extends BaseEntity{
    private String firstName;
    private String lastname;
    private String email;
    private String username;
    private String password;
}
