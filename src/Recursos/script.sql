create table deuda(
codigo INTEGER UNIQUE NOT NULL,
aQuienDebo VARCHAR(50)NOT NULL,
fechaDeuda TIMESTAMP NOT NULL,
cantidad FLOAT NOT NULL,
primary key(codigo) 
);

create table prestamo(
codigo INTEGER UNIQUE NOT NULL,
quienMeDebe VARCHAR(50) NOT NULL,
fechaDeuda TIMESTAMP NOT NULL,
cantidad FLOAT NOT NULL,
primary key(codigo)
);


