package com.dhruvaa___.demo;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.List.of;

@Service
public class SoftwareServices {
    public List<SoftwareEngineer> getEngineer()
    {
        return of(
                new SoftwareEngineer(1,"Jamila", Collections.singletonList("MERN")),
                new SoftwareEngineer(2,"James", Collections.singletonList("Spring")),
                new SoftwareEngineer(3,"Dhruva", Collections.singletonList("Node")));
    }
}

