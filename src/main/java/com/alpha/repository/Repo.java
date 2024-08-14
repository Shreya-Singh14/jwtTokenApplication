package com.alpha.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alpha.EntityClasses.Ent;


@Repository
public interface Repo extends CrudRepository<Ent, Integer> {
	
	/*
	 * Optional<Ent> findByUsernameAndPassword(String username, String password);
	 * 
	 * @Query("select u from Ent u where u.username=:username") public Ent
	 * getUserByUsername(@Param("username")String username);
	 */
	
	Optional<Ent> findByUsername(String username);
	

}

