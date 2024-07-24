drop database if exists T1;

create database T1;

use T1;

create table usuario(
    id bigint not null auto_increment,
    email varchar(256) not null,
    senha varchar(256) not null,
    nome varchar(256) not null,
    papel varchar(20),
    primary key (id)
);

create table cliente(
    id_usuario bigint not null,
    cpf varchar(14) not null,
    telefone varchar(20) not null,
    sexo varchar(256) not null,
    data_nascimento varchar(20) not null,
    foreign key (id_usuario) references usuario(id) on delete cascade,
    unique (cpf)
);

create table imobiliaria(
    id_usuario bigint not null,
    cnpj varchar(18) not null,
    descricao varchar(1024) not null,
    foreign key (id_usuario) references usuario(id) on delete cascade,
    unique (cnpj)
);

create table imovel(
    id bigint not null auto_increment,
    cnpj_imobiliaria varchar(18) not null,
    endereco varchar(256) not null,
    cidade varchar(256) not null,
    descricao varchar(1024) not null,
    valor float not null,
    primary key (id),
    foreign key (cnpj_imobiliaria) references imobiliaria(cnpj) on delete cascade
);

insert into usuario(email, senha, nome, papel)
    values ('admin', 'admin', 'Admin', 'ADMIN');

insert into usuario(email, senha, nome, papel)
    values ('aaaaaaaa@gmail.com', 'senha', 'aaaaaaaaa', 'CLIENTE');

insert into cliente(id_usuario, cpf, telefone, sexo, data_nascimento)
    values ('2', '747.285.293-79', '99574-3211', 'masculino', '17/07/1990');

insert into usuario(email, senha, nome, papel)
    values ('bbbbbbbb@gmail.com', 'senha', 'bbbbbbbbb', 'CLIENTE');

insert into cliente(id_usuario, cpf, telefone, sexo, data_nascimento)
    values ('3', '857.483.953-25', '3948-2859', 'masculino', '27/11/2002');

insert into usuario(email, senha, nome, papel)
    values ('cardinali@imobiliariaria.com', 'senha', 'cardinali', 'AGENCY');

insert into imobiliaria(id_usuario, cnpj, descricao)
    values ('4', '47.661.753/0001-01', 'amarela');

insert into imovel(cnpj_imobiliaria, endereco, cidade, descricao, valor)
    values ('47.661.753/0001-01', 'avenida sao carlos, 727', 'sao carlos', 'amarelo tbm', '727727.0');