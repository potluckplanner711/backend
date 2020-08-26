package com.lambdaschool.bwpotluckplanner711;

import com.lambdaschool.bwpotluckplanner711.models.Potluck;
import com.lambdaschool.bwpotluckplanner711.models.Role;
import com.lambdaschool.bwpotluckplanner711.models.User;
import com.lambdaschool.bwpotluckplanner711.models.UserRoles;
import com.lambdaschool.bwpotluckplanner711.service.PotluckService;
import com.lambdaschool.bwpotluckplanner711.service.RoleService;
import com.lambdaschool.bwpotluckplanner711.service.UserService;
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

    @Autowired
    private PotluckService potluckService;

    @Transactional

    @Override
    public void run(String... args)
            throws
            Exception
    {
        userService.deleteAll();
        roleService.deleteAll();
        potluckService.deleteAll();

        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);

        User u1 = new User("Logan", "Metzger", "loganLlama", "logan@metzger.com", "LambdaLlama");
        u1 = userService.save(u1);
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));
        u1.getPotlucks().add(new Potluck(u1, "City Potluck", "09/082020", "11 am", "101 City Hall Ave", "Town", "Iowa", 55555));

        User u2 = new User("Chayce", "Solchaga", "chayceLlama", "chayce@solchaga.com", "LambdaLlama");
        u2 = userService.save(u2);
        u2.getRoles().add(new UserRoles(u2, r1));
        u2.getRoles().add(new UserRoles(u2, r2));

        User u3 = new User("John", "Smith", "mrSmith01", "john@smith.com", "LambdaLlama");
        u3 = userService.save(u3);
        u3.getRoles().add(new UserRoles(u3, r2));

        User u4 = new User("Jane", "Smith", "mrsSmith", "jane@smith.com", "LambdaLlama");
        u4 = userService.save(u4);
        u4.getRoles().add(new UserRoles(u4, r2));
        u4.getPotlucks().add(new Potluck(u4, "Church Potluck", "09/05/2020", "4:30 pm", "555 W Church Ave", "City", "Iowa", 56565));
        u4.getPotlucks().add(new Potluck(u4, "Smith Potluck", "08/29/2020", "5 pm", "587 Smith St", "City", "Iowa", 56565));

        User u5 = new User("Bobby", "Smith", "mrSmith02", "bobby@smith.com", "LambdaLlama");
        u5 = userService.save(u5);
        u5.getRoles().add(new UserRoles(u5, r2));
    }
}