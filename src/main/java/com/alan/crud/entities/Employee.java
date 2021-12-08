package com.alan.crud.entities;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@Table(name="employee")
public class Employee {  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String matricula;
    public String nome;
    public String sexo;
    public long trainingId;
}