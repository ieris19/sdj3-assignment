DROP SCHEMA SDJHandin CASCADE;
CREATE SCHEMA IF NOT EXISTS SDJHandin;

CREATE TABLE IF NOT EXISTS Animal
(
    registrationNumber BIGINT PRIMARY KEY,
);


CREATE TABLE IF NOT EXISTS Product(
    id BIGINT PRIMARY KEY,
);

CREATE TABLE IF NOT EXISTS AnimalInProduct(
    productId BIGINT REFERENCES Product(id),
    animalId BIGINT REFERENCES Animal(registrationNumber),
    PRIMARY KEY (productId, animalId)
);

