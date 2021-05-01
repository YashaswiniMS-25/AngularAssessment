package com.wolken.wolkenapp.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolken.wolkenapp.Entity.StudentEntity;
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {

	public StudentEntity findByUsn(String usn);
	public StudentEntity findById(int id);

	public StudentEntity findByFirstName(String firstname);
	
	

}
