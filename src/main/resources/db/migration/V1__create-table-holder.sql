create table holder
(

    id         bigint       not null auto_increment PRIMARY KEY ,
    name       varchar(100) not null,
    email      varchar(100) not null,
    phone      varchar(20)  not null,
    cpf        varchar(11)  not null unique,
    street     varchar(100) not null,
    district   varchar(100) not null,
    cep        varchar(9)   not null,
    city       varchar(100) not null,
    uf         char(2)      not null,
    country    varchar(100) not null,
    number     varchar(20)  not null,
    complement varchar(100),
    active     tinyint      not null
);