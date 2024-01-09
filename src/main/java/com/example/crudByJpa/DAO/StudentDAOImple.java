package com.example.crudByJpa.DAO;

import com.example.crudByJpa.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAOImple implements StudentDAO{

    private EntityManager entityManager;
    @Autowired
    public StudentDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //Create a query
        TypedQuery<Student> typedQuery= entityManager.createQuery("From Student",Student.class);
        //return query set
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> typedQuery=entityManager.createQuery("From Student where lastName= :thdata",Student.class);
        typedQuery.setParameter("thdata",lastName);
        return typedQuery.getResultList();
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
     Student student1=entityManager.find(Student.class,id);
     entityManager.remove(student1);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int row=entityManager.createQuery("DELETE from Student ").executeUpdate();
        return row;
    }
}
