package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Catedratico;

public interface ICatedraticoDAO extends JpaRepository<Catedratico, Integer> {

}
