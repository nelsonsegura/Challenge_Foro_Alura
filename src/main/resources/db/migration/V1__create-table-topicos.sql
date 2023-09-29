/* CREATE SCHEMA `foroalura` ; */

create table topicos(

    id bigint not null auto_increment,
    titulo varchar(250) not null,
    mensaje varchar(100) not null,
    fecha_creacion date not null,
    estatus varchar(250) not null,
    autor varchar(250) not null,
    curso varchar(250) not null,

    primary key(id)
);