package zw.co.getsol.blogapplication.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{
    private String name;
    private String email;
    private String body;
}
