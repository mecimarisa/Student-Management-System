package org.mmeci.service;

import jakarta.persistence.EntityManager;
import org.mmeci.entity.Professor;
import org.mmeci.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(EntityManager entityManager) {
        this.professorRepository = new ProfessorRepository(entityManager);
    }

    public void addProfessor(String name, String lastName, String specialization) {
        Professor professor = new Professor(name, lastName, specialization);
        professorRepository.addProfessor(professor);
    }

    public Professor getProfessorById(Long id) {
        Professor professor = professorRepository.getProfessorById(id);
        if (professor == null) {
            System.out.println("Professor with ID " + id + " not found");
        }
        return professor;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.getAllProfessors();
    }

    public void removeProfessorById(Long id) {
        professorRepository.removeProfessorById(id);
        System.out.println("Professor with ID " + id + " removed");
    }
}