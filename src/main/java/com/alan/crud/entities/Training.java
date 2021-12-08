package com.alan.crud.entities;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.Entity;



@Entity
@Data
@NoArgsConstructor
@Table(name="training")
public class Training implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  public String descricao;
  public String codigo;
  public String inicio;
  public String termino;
  public int cargaHoraria;
  public int vagas;
}
