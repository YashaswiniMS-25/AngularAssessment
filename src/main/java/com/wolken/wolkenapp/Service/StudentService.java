package com.wolken.wolkenapp.Service;

import java.util.List;
import java.util.Map;

import com.wolken.wolkenapp.Entity.StudentEntity;

public interface StudentService {

	

	public List<StudentEntity> validateAndFindAll();

	public StudentEntity saveData(StudentEntity entity);

	public StudentEntity validateAndUpdateentity(StudentEntity entitynew, int id);

	public Map<String,Boolean> validateAndDelete(int id);

	public StudentEntity search(int id);

}
