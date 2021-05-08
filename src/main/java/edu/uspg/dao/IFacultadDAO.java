package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Facultad;

public interface IFacultadDAO extends JpaRepository<Facultad, Integer> {

}
