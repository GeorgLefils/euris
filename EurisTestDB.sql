create database euristest;


use euristest;


create table articoli(
 id int primary key auto_increment not null,
 nome varchar(50),
 costo varchar(10)
 );
 
 select * from articoli;
 
 insert into articoli (nome, costo) value
 ('Pc Samsung', '50p'),
 ('Pc Sony', '70s'),
 ('Pc Notebook', '80d'),
 ('Pc Apple', '100p'),
 ('Tv Samsung', '60d'),
 ('Tv Philips', '40d'),
 ('Tv Telefunken', '30p'),
 ('frigorifero Samsung', '25s'),
 ('Iphone 12', '120p'),
 ('Ps5', '75d');
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 