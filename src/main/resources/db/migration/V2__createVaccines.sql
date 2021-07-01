CREATE TABLE vaccines(
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(80) NOT NULL,
    user_id INT NOT NULL,
    application_date timestamp with time zone,
    PRIMARY KEY(id),
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);