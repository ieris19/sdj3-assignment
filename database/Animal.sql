DROP SCHEMA SDJHandin CASCADE;
CREATE SCHEMA IF NOT EXISTS SDJHandin;

CREATE TABLE IF NOT EXISTS Animal
(
    registrationNumber BIGINT PRIMARY KEY,

    refNo              BIGINT REFERENCES Product (refNo)
);


CREATE TABLE IF NOT EXISTS Product(
    refNo BIGINT PRIMARY KEY,
    registrationNo BIGINT REFERENCES Animal(registrationNumber)

);


