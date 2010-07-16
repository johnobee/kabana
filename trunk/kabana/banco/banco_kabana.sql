create table administrador(
id serial,
nome varchar(100) not null,
sobrenome varchar(100) not null,
email varchar(200) not null,
telefone varchar(100) not null, 
login varchar(200) not null,
senha varchar(200) not null,
primary key(id)

);

insert into administrador(nome, sobrenome, email, telefone, login, senha) values ('Milton', 'Domingues', 'mtneto@hotmail.com', '(81)9939-2529', 'neto', '123');
insert into administrador(nome, sobrenome, email, telefone, login, senha) values ('Claudio', 'Cabral', 'claudio@hotmail.com', '(81)8888-2529', 'claudio', '123');
insert into administrador(nome, sobrenome, email, telefone, login, senha) values ('Wallace', 'Ribeiro', 'wallace@hotmail.com', '(81)9999-2529', 'figurao', '123');
