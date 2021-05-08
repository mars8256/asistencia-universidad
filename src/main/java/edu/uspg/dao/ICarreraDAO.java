package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Carrera;

public interface ICarreraDAO extends JpaRepository<Carrera, Integer>{

}
