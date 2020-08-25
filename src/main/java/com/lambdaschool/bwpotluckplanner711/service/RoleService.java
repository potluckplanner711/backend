package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.models.Role;

public interface RoleService
{
    Role findRoleById(long id);

    Role save(Role role);

    Role findByName(String name);

    public void deleteAll();
}