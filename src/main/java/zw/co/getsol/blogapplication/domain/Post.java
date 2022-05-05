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
@Table(name = "post")
public class Post extends BaseEntity{
    private String title;
    private String description;
    private String content;

}
