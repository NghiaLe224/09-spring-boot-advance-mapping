package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findById(int id);
    void deleteById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}

