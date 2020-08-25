package com.lambdaschool.bwpotluckplanner711.repositories;

import com.lambdaschool.bwpotluckplanner711.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>
{
    Role findByNameIgnoreCase(String name);
}