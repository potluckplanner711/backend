package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.PotluckPlannerApplication;
import com.lambdaschool.bwpotluckplanner711.exceptions.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PotluckPlannerApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImpTest
{
    @Autowired
    private UserService userService;

    @Before
    public void setUp()
            throws
            Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown()
            throws
            Exception
    {
    }

    @Test
    public void a_findAll()
    {
        assertEquals(5, userService.findAll().size());
    }

    @Test
    public void save()
    {
    }

    @Test
    public void b_findByUsername()
    {
        assertEquals("loganllama", userService.findByUsername("loganllama").getUsername());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void ba_findByUsernameNotFound()
    {
        assertEquals("turtle", userService.findByUsername("turtle").getUsername());
    }

    @Test
    public void c_findByUserId()
    {
        assertEquals("loganllama", userService.findByUserId(5).getUsername());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void ca_findByUserIdNotFound()
    {
        assertEquals("loganllama", userService.findByUserId(100).getUsername());
    }

    @Test
    public void d_deleteAll()
    {
        userService.deleteAll();
        assertEquals(0, userService.findAll().size());
    }
}