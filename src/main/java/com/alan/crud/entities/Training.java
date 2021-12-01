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
@Table(name="trainings")
public class Training {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  public String matricula;
  public String name;
  public String sexo;
}
