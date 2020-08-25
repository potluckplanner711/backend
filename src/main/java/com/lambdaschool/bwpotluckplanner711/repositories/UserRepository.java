package com.lambdaschool.bwpotluckplanner711.repositories;

import com.lambdaschool.bwpotluckplanner711.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}