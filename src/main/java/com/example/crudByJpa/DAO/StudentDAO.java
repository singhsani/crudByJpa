package com.example.crudByJpa.DAO;

import com.example.crudByJpa.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Long id);
    int deleteAll();
}
