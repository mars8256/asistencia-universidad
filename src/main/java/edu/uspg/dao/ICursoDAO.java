package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Curso;

public interface ICursoDAO extends JpaRepository<Curso, Integer> {

}
