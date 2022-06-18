use libreria;

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