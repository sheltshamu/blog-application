package zw.co.getsol.blogapplication.service;

import zw.co.getsol.blogapplication.domain.Role;
import zw.co.getsol.blogapplication.dto.RoleDto;
import zw.co.getsol.blogapplication.persistence.RoleRepository;
import zw.co.getsol.blogapplication.request.RoleRequest;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto create(RoleRequest roleRequest) {
        Role role = new Role();
        role.setName(roleRequest.getName());
        roleRepository.save(role);
        return new RoleDto(role);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtoList = new ArrayList<>();
        roles.stream().forEach(role -> {
            roleDtoList.add(new RoleDto(role));
        });
      return roleDtoList;
    }
}
