create database libreria;
use libreria;

create table autor(
	id_autor int not null auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    fecha_creacion date not null,
    fecha_eliminacion date null,
    primary key(id_autor)
);

create table libro(
	id_libro int not null auto_increment,
    nombre varchar(100) not null,
    paginas int not null,
    precio int not null,
    fecha_creacion date not null,
    fecha_eliminacion date null,
    id_autor int not null references autor(autor_id),
    primary key(id_libro)
);