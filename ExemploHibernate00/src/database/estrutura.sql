DROP DATABASE IF EXISTS exemplo_hibernate_00;
CREATE DATABASE exemplo_hibernate_00;
USE exemplo_hibernate_00;



CREATE TABLE sistemas(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(150)
);

CREATE TABLE alunos(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(150),
nota1 DOUBLE,
nota2 DOUBLE,
nota3 DOUBLE,
nota4 DOUBLE,
quantidade_faltas INT 
);