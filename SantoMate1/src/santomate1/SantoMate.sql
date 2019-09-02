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
quant int not null,
id_erva int references ervaMate(id),
primary key(id_erva)
);

create table comprador(
CPF varchar(11) primary key,
nome varchar(50) not null,
CEP int,
telefone int not null
);

create table venda(
id_erva int references ervaMate(id),
comprador_CPF varchar(11) references comprador(CPF),
id int primary key
);

insert into ErvaMate values (1, "Ximango", "Trandicional", 2.0, 18.00);
insert into ErvaMate values (2, "Ximango", "Trandicional", 4.0, 36.00);
insert into ErvaMate values (3, "Ximango", "Trandicional", 6.0, 54.00);
insert into ErvaMate values (4, "Ximango", "Moida Grossa", 2.0, 18.00);
insert into ErvaMate values (5, "Ximango", "Moida Grossa", 4.0, 36.00);
insert into ErvaMate values (6, "Ximango", "Moida Grossa", 6.0, 54.00);
insert into ErvaMate values (7, "Ximango", "Pura Folha", 2.0, 18.00);
insert into ErvaMate values (8, "Ximango", "Pura Folha", 4.0, 36.00);
insert into ErvaMate values (9, "Ximango", "Pura Folha", 6.0, 54.00);
insert into ErvaMate values (10, "Rei Verde", "Trandicional", 2.0, 20.00);
insert into ErvaMate values (11, "Rei Verde", "Trandicional", 4.0, 40.00);
insert into ErvaMate values (12, "Rei Verde", "Trandicional", 6.0, 60.00);
insert into ErvaMate values (13, "Rei Verde", "Pura Folha", 2.0, 20.00);
insert into ErvaMate values (14, "Rei Verde", "Pura Folha", 4.0, 40.00);
insert into ErvaMate values (15, "Rei Verde", "Pura Folha", 6.0, 60.00);
insert into ErvaMate values (16, "Rei Verde", "Moida Grossa", 2.0, 20.00);
insert into ErvaMate values (17, "Rei Verde", "Moida Grossa", 4.0, 40.00);
insert into ErvaMate values (18, "Rei Verde", "Moida Grossa", 6.0, 60.00);
insert into ErvaMate values (19, "Pastoreio", "Trandicional", 2.0, 18.00);
insert into ErvaMate values (20, "Pastoreio", "Trandicional", 4.0, 36.00);
insert into ErvaMate values (21, "Pastoreio", "Trandicional", 6.0, 54.00);
insert into ErvaMate values (22, "Pastoreio", "Moida Grossa", 2.0, 18.00);
insert into ErvaMate values (23, "Pastoreio", "Moida Grossa", 4.0, 36.00);
insert into ErvaMate values (24, "Pastoreio", "Moida Grossa", 6.0, 54.00);
insert into ErvaMate values (25, "Pastoreio", "Pura Folha", 2.0, 18.00);
insert into ErvaMate values (26, "Pastoreio", "Pura Folha", 4.0, 36.00);
insert into ErvaMate values (27, "Pastoreio", "Pura Folha", 6.0, 54.00);

