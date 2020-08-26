package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.exceptions.ResourceFoundException;
import com.lambdaschool.bwpotluckplanner711.exceptions.ResourceNotFoundException;
import com.lambdaschool.bwpotluckplanner711.models.Potluck;
import com.lambdaschool.bwpotluckplanner711.models.Role;
import com.lambdaschool.bwpotluckplanner711.models.User;
import com.lambdaschool.bwpotluckplanner711.models.UserRoles;
import com.lambdaschool.bwpotluckplanner711.repositories.UserRepository;
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

    @Autowired
    private PotluckService potluckService;

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
        newUser.setUsername(user.getUsername().toLowerCase());
        newUser.setEmail(user.getEmail().toLowerCase());
        newUser.setPassword(user.getPassword());

        newUser.getRoles().clear();
        for (UserRoles ur : user.getRoles())
        {
            Role addRole = roleService.findRoleById(ur.getRole().getRoleid());
            newUser.getRoles().add(new UserRoles(newUser, addRole));
        }

        newUser.getPotlucks().clear();
        for (Potluck pl : user.getPotlucks())
        {
            newUser.getPotlucks().add(new Potluck(newUser,
                    pl.getTitle(),
                    pl.getDate(),
                    pl.getTime(),
                    pl.getAddress(),
                    pl.getCity(),
                    pl.getState(),
                    pl.getZip()));
        }

        return userRepos.save(newUser);
    }

    @Override
    public User findByUsername(String username)
    {
        User u = userRepos.findByUsername(username.toLowerCase());
        if (u == null)
        {
            throw new ResourceFoundException("Username " + username + " not found!");
        }
        return u;
    }

    @Override
    public User findByUserId(long id) throws ResourceFoundException
    {
        return userRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        userRepos.deleteAll();
    }
}