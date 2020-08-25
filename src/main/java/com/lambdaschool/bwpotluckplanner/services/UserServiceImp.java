package com.lambdaschool.bwpotluckplanner.services;

import com.lambdaschool.bwpotluckplanner.models.Role;
import com.lambdaschool.bwpotluckplanner.models.User;
import com.lambdaschool.bwpotluckplanner.models.UserRoles;
import com.lambdaschool.bwpotluckplanner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userservice")
public class UserServiceImp implements UserService
{
    @Autowired
    private UserRepository userRepos;

    @Autowired
    private RoleService roleService;

    @Override
    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userRepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public User save(User user)
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userRepos.findById(user.getUserid()).orElseThrow(() -> new EntityNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setFname(user.getFname().toLowerCase());
        newUser.setLname(user.getLname().toLowerCase());
        newUser.setEmail(user.getEmail().toLowerCase());
        newUser.setPassword(user.getPassword());

        newUser.getRoles().clear();
        for (UserRoles ur : user.getRoles())
        {
            Role addRole = roleService.findRoleById(ur.getRole().getRoleid());
            newUser.getRoles().add(new UserRoles(newUser, addRole));
        }

        return userRepos.save(newUser);
    }
}
