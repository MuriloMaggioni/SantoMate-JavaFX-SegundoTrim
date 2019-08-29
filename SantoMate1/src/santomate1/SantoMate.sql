create database SantoMate;
use SantoMate;

create table ervaMate(
id int primary key,
marca varchar(50) not null,
tipo varchar(50) not null,
peso float not null,
preco float not null
);

create table vendedor(
CPF varchar(11) primary key,
nome varchar(50) not null,
idade int not null, 
CEP int,
salario decimal not null,
telefone int not null
);

create table estoque(
id int primary key,
quant int not null,
id_erva int not null references ervaMate(id)
);

create table comprador(
CPF varchar(11) primary key,
nome varchar(50) not null,
CEP int,
telefone int not null
);

create table venda(
id_estoque int references estoque(id),
vendedor_CPF varchar(11) references vendedor(CPF),
comprador_CPF varchar(11) references comprador(CPF),
id int primary key,
quantidade int not null,
tipo varchar(50) not null,
peso float not null,
marca varchar(50) not null
);
