package com.wolken.wolkenapp.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.Entity.StudentEntity;
import com.wolken.wolkenapp.REPOSITORY.StudentRepo;

@Service
public class StudentSerbviceImpl  implements StudentService{
	Logger logger=Logger.getLogger("StudentServiceImpl");
@Autowired
StudentRepo studentrepo;
	@Override
	public List<StudentEntity> validateAndFindAll() {
		logger.info("inside validateAndAll");
		return studentrepo.findAll();
		
	}

	@Override
	public StudentEntity saveData(StudentEntity entity) {
		logger.info(" inside Save Data");
	
				StudentEntity entity1=studentrepo.save(entity);
				if(entity!=null) {
					return entity1;
				}
				else {
					return null;
				}
				
				
	}

	@Override
	public StudentEntity validateAndUpdateentity(StudentEntity entitynew, int id) {
		logger.info("inside valiadte and update");
		
			StudentEntity entity=studentrepo.findById(id);
			if(entity!=null) {
				entity.setEmailId(entitynew.getEmailId());
				entity.setFirstName(entitynew.getFirstName());
				entity.setLastName(entitynew.getLastName());
				entity.setDob(entitynew.getDob());
				entity.setMblno(entitynew.getMblno());
				entity.setUsn(entitynew.getUsn());
				studentrepo.save(entity);
				return entity;
			}
			else {
				return null;
			}
			
			
		}
	

	@Override
	public  Map<String,Boolean> validateAndDelete(int id) {
	if(id>0) {
		logger.info("inside valiadteAndUpdate");
		StudentEntity entity1=studentrepo.findById(id);
		if(entity1!=null) {
			studentrepo.delete(entity1);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return response;
			
		}
		else {
			return  null;
		}
	}else
		return null;
	}

	@Override
	public StudentEntity search(int id) {
		logger.info("inside student entity search");
		
		
				
	return studentrepo.findById(id);
	

	}
	}
