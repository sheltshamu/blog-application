package zw.co.getsol.blogapplication.service;


import zw.co.getsol.blogapplication.dto.PostDto;
import zw.co.getsol.blogapplication.dto.RoleDto;
import zw.co.getsol.blogapplication.request.RoleRequest;

import java.util.List;

public interface RoleService {
    RoleDto create(RoleRequest roleRequest);
    List<RoleDto> getAllRoles();
}
