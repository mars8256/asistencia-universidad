package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Token;

public interface ITokenDAO extends JpaRepository<Token, Integer> {

}
