package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.exceptions.ResourceNotFoundException;
import com.lambdaschool.bwpotluckplanner711.models.Type;
import com.lambdaschool.bwpotluckplanner711.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "typeservice")
public class TypeServiceImp implements TypeService
{
    @Autowired
    private TypeRepository typeRepos;

    @Override
    public Type findTypeById(long id)
    {
        return typeRepos.findById(id). orElseThrow(() -> new ResourceNotFoundException("Type id " + id + " not found!"));
    }

    @Override
    public Type findByName(String name)
    {
        Type t = typeRepos.findByNameIgnoreCase(name);

        if (t != null)
        {
            return t;
        } else
        {
            throw new ResourceNotFoundException("Type name " + name + " not found!");
        }
    }

    @Transactional
    @Override
    public Type save(Type type)
    {
        if (type.getAttendees().size() > 0)
        {
            throw new ResourceNotFoundException("Attendee types are not updated through Type.");
        }

        return typeRepos.save(type);
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        typeRepos.deleteAll();
    }
}
