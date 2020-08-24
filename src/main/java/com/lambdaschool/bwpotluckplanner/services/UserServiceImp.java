package com.lambdaschool.bwpotluckplanner.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "userservice")
public class UserServiceImp implements UserService
{
}
