package com.lambdaschool.bwpotluckplanner711.repositories;

import com.lambdaschool.bwpotluckplanner711.models.Attendee;
import org.springframework.data.repository.CrudRepository;

public interface AttendeeRepository extends CrudRepository<Attendee, Long>
{
}
