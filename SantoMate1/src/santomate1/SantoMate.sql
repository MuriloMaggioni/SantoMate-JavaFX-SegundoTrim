create table SantoMate;
use SantoMate;

create table ervaMate(
id int primary key,
marca varchar(50) not null,
tipo varchar(50) not null,
peso float not null,
preco float not null
);

create table vendedor(
CPF int primary key,
nome varchar(50) not null,
idade int not null, 
CEP int not null,
salario decimal not null
);

create table venda(

);
