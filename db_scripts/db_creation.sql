show databases;

create database ontrack_db;

use ontrack_db;

show tables;

create table ano_letivo (
	id INT not null auto_increment,
    ano VARCHAR(10) not null,
    primary key (id)
);

create table professor (
	id int not null auto_increment,
    nome varchar(40) not null,
    email varchar(50) not null,
    primary key(id)
);

create table aluno (
	id int not null auto_increment,
    nome varchar(40) not null,
    email varchar(50) not null,
    primary key (id)
);

create table avaliacao (
	id int not null auto_increment,
    nome varchar(40) not null,
    data DATE,
    primary key (id)
);

create table curso(
	id int not null auto_increment,
    nome varchar(40) not null,
    codigo int not null,
    primary key (id)
);

CREATE TABLE unidade_curricular (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    semestre int not null,
    ano int not null,
    descrição varchar(100),
    id_ano_letivo INT NOT NULL,
    id_avaliacao INT NOT NULL,
    id_curso INT NOT NULL,
    PRIMARY KEY (id),
     FOREIGN KEY (id_ano_letivo) REFERENCES ano_letivo(id) ON DELETE CASCADE,
    FOREIGN KEY (id_avaliacao) REFERENCES avaliacao(id) ON DELETE CASCADE,
    FOREIGN KEY (id_curso) REFERENCES curso(id) ON DELETE CASCADE
);

CREATE TABLE aluno_unidade_curricular (
    aluno_id INT NOT NULL,
    unidade_curricular_id INT NOT NULL,
    PRIMARY KEY (aluno_id, unidade_curricular_id),
    FOREIGN KEY (aluno_id) REFERENCES aluno (id),
    FOREIGN KEY (unidade_curricular_id) REFERENCES unidade_curricular (id)
);

create table professor_unidade_curricular (
	professor_id int not null,
    unidade_curricular_id int not null,
    primary key (professor_id, unidade_curricular_id),
    foreign key (professor_id) references professor (id),
    FOREIGN KEY (unidade_curricular_id) REFERENCES unidade_curricular (id)
);


