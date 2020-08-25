package com.lambdaschool.bwpotluckplanner;

import com.lambdaschool.bwpotluckplanner.models.Role;
import com.lambdaschool.bwpotluckplanner.models.User;
import com.lambdaschool.bwpotluckplanner.models.UserRoles;
import com.lambdaschool.bwpotluckplanner.services.RoleService;
import com.lambdaschool.bwpotluckplanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Transactional

    @Override
    public void run(String... args)
            throws
            Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);

        User u1 = new User("Logan", "Metzger", "loganLlama", "logan@metzger.com", "LambdaLlama");
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));

        userService.save(u1);

        User u2 = new User("Chayce", "Solchaga", "chayceLlama", "chayce@solchaga.com", "LambdaLlama");
        u2.getRoles().add(new UserRoles(u2, r1));
        u2.getRoles().add(new UserRoles(u2, r2));

        userService.save(u2);

        User u3 = new User("John", "Smith", "mrSmith01", "john@smith.com", "LambdaLlama");
        u3.getRoles().add(new UserRoles(u3, r2));

        userService.save(u3);

        User u4 = new User("Jane", "Smith", "mrsSmith", "jane@smith.com", "LambdaLlama");
        u4.getRoles().add(new UserRoles(u4, r2));

        userService.save(u4);

        User u5 = new User("Bobby", "Smith", "mrSmith02", "bobby@smith.com", "LambdaLlama");
        u5.getRoles().add(new UserRoles(u5, r2));

        userService.save(u5);
    }
}
