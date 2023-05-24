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
                           nome VARCHAR(40) not null,
                           email VARCHAR(50) not null,
                           primary key(id)
);

create table aluno (
                       id int not null auto_increment,
                       nome VARCHAR(40) not null,
                       email VARCHAR(50) not null,
                       primary key(id)
);

CREATE TABLE unidade_curricular (
                                    id INT NOT NULL AUTO_INCREMENT,
                                    nome VARCHAR(50) NOT NULL,
                                    codigo VARCHAR(15) NOT NULL,
                                    descrição varchar(100),
                                    ano int not null,
                                    semestre int not null,
                                    PRIMARY KEY (id)
);