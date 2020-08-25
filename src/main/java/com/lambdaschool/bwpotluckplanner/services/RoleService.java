package com.lambdaschool.bwpotluckplanner.services;

import com.lambdaschool.bwpotluckplanner.models.Role;

public interface RoleService
{
    Role findRoleById(long id);

    Role save(Role role);

    Role findByName(String name);
}
