package zw.co.getsol.blogapplication.dto;

import lombok.Getter;
import zw.co.getsol.blogapplication.domain.Role;
@Getter
public final class RoleDto {
    private String name;

    public RoleDto(Role role) {
        this.name = role.getName();
    }
}
