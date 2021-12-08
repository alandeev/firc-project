create database springbootdb;

use springbootdb;

CREATE TABLE Training (
  id int NOT NULL AUTO_INCREMENT,
  descricao varchar(50) NOT NULL,
  codigo int NOT NULL,
  inicio varchar(30) NOT NULL,
  termino varchar(30) NOT NULL,
  cargaHoraria int NOT NULL,
  vagas int not null,
  PRIMARY KEY(id)
);

CREATE TABLE Employee (
  id int NOT NULL AUTO_INCREMENT,
  matricula varchar(10) NOT NULL,
  nome varchar(30) NOT NULL,
  sexo char NOT NULL,
  trainingId int NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (trainingId) REFERENCES Training(id)
);