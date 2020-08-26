package com.lambdaschool.bwpotluckplanner711.repositories;

import com.lambdaschool.bwpotluckplanner711.models.Potluck;
import org.springframework.data.repository.CrudRepository;

public interface PotluckRepository extends CrudRepository<Potluck, Long>
{
}
