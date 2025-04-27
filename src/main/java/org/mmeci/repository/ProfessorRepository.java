package org.mmeci.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.mmeci.entity.Professor;

import java.util.List;

public class ProfessorRepository {

    private final EntityManager entityManager;

    public ProfessorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addProfessor(Professor professor) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(professor);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Professor getProfessorById(Long id) {
        return entityManager.find(Professor.class, id);
    }

    public List<Professor> getAllProfessors() {
        return entityManager.createQuery("FROM Professor", Professor.class).getResultList();
    }

    public void removeProfessorById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Professor professor = entityManager.find(Professor.class, id);
            if (professor != null) {
                entityManager.remove(professor);
                System.out.println("Professor removed successfully: " + professor.getName());
            } else {
                System.out.println("Professor with ID " + id + " not found");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}