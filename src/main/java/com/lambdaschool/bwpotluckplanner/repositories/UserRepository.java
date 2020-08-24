package com.lambdaschool.bwpotluckplanner.repositories;

import com.lambdaschool.bwpotluckplanner.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
}
