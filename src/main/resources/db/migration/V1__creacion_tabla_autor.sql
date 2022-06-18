use libreria;

create table autor(
	id_autor int not null auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    fecha_creacion date not null,
    fecha_eliminacion date null,
    primary key(id_autor)
);