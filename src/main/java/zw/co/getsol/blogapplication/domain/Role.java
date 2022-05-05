package zw.co.getsol.blogapplication.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role extends BaseEntity{
    private String name;
}
