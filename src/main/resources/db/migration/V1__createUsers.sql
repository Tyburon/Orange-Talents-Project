CREATE TABLE users(
        id INT GENERATED ALWAYS AS IDENTITY,
        name VARCHAR(80) NOT NULL,
        email VARCHAR(80) NOT NULL UNIQUE,
        cpf VARCHAR(80) NOT NULL UNIQUE,
        data_nasc timestamp with time zone,
        PRIMARY KEY(id)
);

insert into users (name, email, cpf, data_nasc) values  ('Gabriel', 'gabriel@gmail.com', '09334390085', '2001-06-11');

insert into users (name, email, cpf, data_nasc) values  ('Cezar', 'cezar@gmail.com', '30539352012', '2001-06-11');