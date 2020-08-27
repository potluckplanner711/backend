package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.models.Attendee;
import com.lambdaschool.bwpotluckplanner711.models.Type;

public interface AttendeeService
{
    Attendee save(long potluckid, String fname, String lname, Type type, boolean isgoing);

    public void deleteAll();
}
