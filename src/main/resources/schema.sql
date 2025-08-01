CREATE TABLE IF NOT EXISTS flight
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    code        VARCHAR(255) NOT NULL,
    origin      VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    status      VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS flight_passengers (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     flight BIGINT NOT NULL,
     passenger BIGINT NOT NULL
);


CREATE TABLE IF NOT EXISTS passenger (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);