package com.wolken.wolkenapp.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.Entity.StudentEntity;
import com.wolken.wolkenapp.Service.StudentService;

@RestController
@RequestMapping("/")
@Controller
@CrossOrigin(origins = "http://localhost:4500")

public class StudentRes {
	Logger logger=Logger.getLogger("StudentRes");

	
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/getAll")
	public List<StudentEntity> getAll(){
		 logger.info("inside getall");
		return studentservice.validateAndFindAll();
      
		
	}
	@PostMapping("/getAll")
	public StudentEntity savedata(@RequestBody StudentEntity entity) {
		logger.info("inside save");
		
		return studentservice.saveData(entity);
		
	}
	@PutMapping("/getAll/{id}")
	public StudentEntity updateEmailByUsn(@PathVariable int id,@RequestBody StudentEntity entity) {
		logger.info("inside update");
		return  studentservice.validateAndUpdateentity(entity,id);
		}
	
	
	@DeleteMapping("/getAll/{id}")
	public Map<String,Boolean>deleteByUsn(@PathVariable int id) {
		logger.info("inside delete");
		Map<String,Boolean> response=new HashMap<>();
		response=studentservice.validateAndDelete(id);
		return response;
	}
	@GetMapping("/getAll/{id}")
	public StudentEntity search(@PathVariable int id){
		logger.info("inside search");
		return studentservice.search(id);

}
}
