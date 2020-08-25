package com.lambdaschool.bwpotluckplanner711;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PotluckPlannerApplication extends SpringBootServletInitializer
{

    public static void main(String[] args)
    {
        SpringApplication.run(PotluckPlannerApplication.class,
                args);
    }

}
