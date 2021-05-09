package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.CursoCatedratico;

public interface ICursoCatedraticoDAO extends JpaRepository<CursoCatedratico,Integer> {

}
