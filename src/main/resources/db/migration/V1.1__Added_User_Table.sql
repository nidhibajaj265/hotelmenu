CREATE TABLE IF NOT EXISTS users (
        id serial PRIMARY KEY,
        name varchar(100) NOT NULL,
        email varchar(100) NOT NULL,
        role varchar(100) NOT NULL,
        password varchar(100) NOT NULL);