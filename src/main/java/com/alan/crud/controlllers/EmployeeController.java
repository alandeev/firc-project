package com.alan.crud.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  @Autowired
  TrainingRepository trainingRepository;

  @GetMapping
  public Iterable<Employee> list() {
    return employeeRepository.findAll();
  }

  @PostMapping
  public Object save(@RequestBody Employee model) {
    var optionalTraining = trainingRepository.findById(model.trainingId);
    if(optionalTraining.isEmpty()) {
      JSONObject response = new JSONObject();

      response.put("status", "error");
      response.put("message", "training not found");
      return response;      
    }

    employeeRepository.save(model);

    return model;
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

  @PutMapping(path="{id}")
  public Object update(@PathVariable long id, @RequestBody Employee model) {
    return employeeRepository.findById(id).map(record -> {
      record.matricula = model.matricula;
      record.nome = model.nome;
      record.sexo = model.sexo;

      var updated = employeeRepository.save(record);
      return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
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
