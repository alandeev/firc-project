package com.alan.crud.entities;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;

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

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "trainingId", nullable = false)
    public int trainingId;
}