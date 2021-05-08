package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idToken;
	@Column(name = "token", nullable = false, length = 10)
	String token;
	
	
	public Integer getIdToken() {
		return idToken;
	}
	public void setIdToken(Integer idToken) {
		this.idToken = idToken;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
