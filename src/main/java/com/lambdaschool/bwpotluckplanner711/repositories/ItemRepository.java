package com.lambdaschool.bwpotluckplanner711.repositories;

import com.lambdaschool.bwpotluckplanner711.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>
{
}
