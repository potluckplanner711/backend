package com.lambdaschool.bwpotluckplanner.services;

import com.lambdaschool.bwpotluckplanner.models.Role;
import com.lambdaschool.bwpotluckplanner.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "roleservice")
public class RoleServiceImp implements RoleService
{
    @Autowired
    RoleRepository roleRepos;

    @Override
    public Role findRoleById(long id)
    {
        return roleRepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Role id " + id + " not found!"));
    }

    @Transactional
    @Override
    public Role save(Role role)
    {
        if (role.getUsers().size() > 0)
        {
            throw new EntityNotFoundException("User Roles are not updated through Role.");
        }

        return roleRepos.save(role);
    }

    @Override
    public Role findByName(String name)
    {
        Role r = roleRepos.findByNameIgnoreCase(name);

        if (r != null)
        {
            return r;
        } else
        {
            throw new EntityNotFoundException(name);
        }
    }
}
