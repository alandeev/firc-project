package com.alan.crud.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

import com.alan.crud.entities.Employee;
import com.alan.crud.repositories.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping
  public Iterable<Employee> list() {
    return employeeRepository.findAll();
  }

  @PostMapping
  public Employee save(@RequestBody Employee employee) {
    employeeRepository.save(employee);
    return employee;
  }

  @GetMapping(path="{id}")
  public Object get(@PathVariable Long id) {
    var employee = employeeRepository.findById(id);

    JSONObject response = new JSONObject();

    if(employee.isEmpty()) {
      response.put("status", "error");
      response.put("message", "id not found");
      return response;
    }

    response.put("status", "success");
    response.put("data", employee);

    return response;
  }

  @DeleteMapping(path="{id}")
  public Object delete(@PathVariable Long id) {
    var employee = employeeRepository.findById(id);

    JSONObject response = new JSONObject();
    if(employee.isEmpty()) {
      response.put("status", "error");
      response.put("message", "id not found");
      return response;
    }

    employeeRepository.deleteById(id);

    response.put("status", "success");
    response.put("message", "employee removed with success");
    return response;
  }
}
