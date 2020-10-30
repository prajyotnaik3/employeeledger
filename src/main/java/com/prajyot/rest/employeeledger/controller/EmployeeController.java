package com.prajyot.rest.employeeledger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prajyot.rest.employeeledger.domain.Employee;
import com.prajyot.rest.employeeledger.exception.ResourceNotFoundException;
import com.prajyot.rest.employeeledger.repository.EmployeeRepository;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Create
	@PostMapping(value = "/employees")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Employee save(@RequestBody Employee employee) {
		//System.out.println(employee.getEmployeeCode() + employee.getName() + employee.getDesignation());
		return employeeRepository.save(employee);
	 }
	//curl -s -v -H "Content-Type: application/json;accpet:application/json" -X POST -d  "{\"employeeCode\":104,\"name\":\"John White\",\"designation\":\"Web Developer\"}" http://localhost:8088/restapi/employees/
	
	//Read
	@GetMapping(value = "/employees")
	   public Page<Employee> all (Pageable pageable){ 
              return employeeRepository.findAll(pageable);
	         
	   }
	//curl http://localhost:8088/restapi/employees/ 

	@GetMapping(value = "/employees/{employeeCode}") 
	   public Employee findByEmployeeCode (@PathVariable Integer employeeCode){ 
	         return employeeRepository.findById(employeeCode).orElseThrow(() -> new ResourceNotFoundException("Employee [employeeCode="+employeeCode+"] can't be found"));
	   }
	//curl http://localhost:8088/restapi/employees/101
	
	//Delete
	@DeleteMapping(value = "/employees/{employeeCode}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeCode){

		return employeeRepository.findById(employeeCode).map(customer -> {
		employeeRepository.delete(customer);
		return ResponseEntity.ok().build();
		}
        ).orElseThrow(() -> new ResourceNotFoundException("Employee [employeeCode="+employeeCode+"] can't be found"));

	}
	//curl -s -i -H "Content-Type: application/json;accept: application/json" -X DELETE  http://localhost:8088/restapi/employees/104/
	
	//Update
	@PutMapping(value = "/employees/{employeeCode}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeCode,@RequestBody Employee newEmployee){
		
		return employeeRepository.findById(employeeCode).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setDesignation(newEmployee.getDesignation());
			employeeRepository.save(employee);
			return ResponseEntity.ok(employee);
		}).orElseThrow(() -> new ResourceNotFoundException("Employee [employeeCode="+employeeCode+"] can't be found"));	
	}
	//curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d "{\"employeeCode\":103,\"name\":\"Adam Hold\",\"designation\":\".Net Developer\"}" http://localhost:8088/restapi/employees/103
}
