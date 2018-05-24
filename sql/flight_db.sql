DROP DATABASE IF EXISTS flight_db;

CREATE DATABASE flight_db;

\connect flight_db

-- role table - ok
CREATE TABLE role (
    role_id SERIAL NOT NULL,
    role_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (role_id)
);

-- login account table - ok
CREATE TABLE account (
    uid SERIAL NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role (role_id),
    PRIMARY KEY (uid)
);

-- passenger info table - ok
CREATE TABLE passenger (
    pid SERIAL NOT NULL,
    uid INT NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    ssn VARCHAR(10) NOT NULL CHECK (LENGTH(ssn) = 9),
    age INT NOT NULL,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    zip INT NOT NULL,
    phone VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    FOREIGN KEY (uid) REFERENCES account (uid),
    PRIMARY KEY (pid)
);

-- airplane info - ok
CREATE TABLE airplane (
    airplane_id SERIAL NOT NULL,
    airplane_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (airplane_id)
);

-- seat type table - ok
CREATE TABLE seat_type (
    seat_type_id SERIAL NOT NULL,
    seat_type_name VARCHAR(50) NOT NULL CHECK (LENGTH(seat_type_name) > 0),
    PRIMARY KEY (seat_type_id)
);

-- airplane seat table - ok
CREATE TABLE airplane_seat (
    airplane_id INT NOT NULL,
    seat_type_id INT NOT NULL,
    seat_num INT NOT NULL,
    FOREIGN KEY (airplane_id) REFERENCES airplane (airplane_id),
    FOREIGN KEY (seat_type_id) REFERENCES seat_type (seat_type_id),
    PRIMARY KEY (airplane_id, seat_type_id)
);

-- city
CREATE TABLE city (
    city_id SERIAL NOT NULL,
    city_name VARCHAR(50) NOT NULL,
    time_zone VARCHAR(50) NOT NULL,
    PRIMARY KEY (city_id)
);

-- flight table - ok
CREATE TABLE flight (
    flight_id SERIAL NOT NULL,
    relative_departure_time TIMESTAMP NOT NULL,
    relative_arrival_time TIMESTAMP NOT NULL,
    departure_city_id INT NOT NULL,
    arrival_city_id INT NOT NULL,
    airplane_id INT NOT NULL,
    FOREIGN KEY (airplane_id) REFERENCES airplane (airplane_id),
    FOREIGN KEY (departure_city_id) REFERENCES city (city_id),
    FOREIGN KEY (arrival_city_id) REFERENCES city (city_id),
    PRIMARY KEY (flight_id)
);

-- schedule of flight table - ok
CREATE TABLE schedule (
    schedule_id SERIAL NOT NULL,
    flight_id INT NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL,
    departure_city VARCHAR(50) NOT NULL,
    arrival_city VARCHAR(50) NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flight (flight_id),
    PRIMARY KEY (schedule_id)
);

-- reserved seats - ok
CREATE TABLE reserved_seat (
    schedule_id INT NOT NULL,
    seat_type_id INT NOT NULL,
    available_seat_num INT NOT NULL,
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id),
    FOREIGN KEY (seat_type_id) REFERENCES seat_type (seat_type_id),
    PRIMARY KEY (schedule_id, seat_type_id)
);

-- price table - ok
CREATE TABLE flight_price (
    schedule_id INT NOT NULL UNIQUE,
    price NUMERIC(10, 2),
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id)
);

-- booking table - ok
CREATE TABLE booking (
    booking_id SERIAL NOT NULL,
    pid INT NOT NULL,
    schedule_id INT NOT NULL,
    baggage VARCHAR(50),
    seat_num INT NOT NULL,
    class_id INT NOT NULL,
    FOREIGN KEY (pid) REFERENCES passenger (pid),
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id),
    PRIMARY KEY (booking_id)
);

-- role
INSERT INTO role VALUES (DEFAULT, 'admin');
INSERT INTO role VALUES (DEFAULT, 'customer');

-- account
INSERT INTO account VALUES (DEFAULT, 'admin', 'admin', 1);
INSERT INTO account VALUES (DEFAULT, 'demo', 'demo', 2);
INSERT INTO account VALUES (DEFAULT, 'customer', 'customer', 2);

-- airplane
INSERT INTO airplane VALUES (DEFAULT, 'Boeing 707');
INSERT INTO airplane VALUES (DEFAULT, 'Boeing 727');
INSERT INTO airplane VALUES (DEFAULT, 'Boeing 757');
INSERT INTO airplane VALUES (DEFAULT, 'Boeing 767');
INSERT INTO airplane VALUES (DEFAULT, 'Boeing 777');
INSERT INTO airplane VALUES (DEFAULT, 'Boeing 787');
INSERT INTO airplane VALUES (DEFAULT, 'Airbus A320');
INSERT INTO airplane VALUES (DEFAULT, 'Airbus A330');
INSERT INTO airplane VALUES (DEFAULT, 'Airbus A380');

-- seat type
INSERT INTO seat_type VALUES (DEFAULT, 'First Class');
INSERT INTO seat_type VALUES (DEFAULT, 'Business');
INSERT INTO seat_type VALUES (DEFAULT, 'Economy');

-- airplane seat
INSERT INTO airplane_seat VALUES (1, 1, 20);
INSERT INTO airplane_seat VALUES (1, 2, 30);
INSERT INTO airplane_seat VALUES (1, 3, 80);

-- city
INSERT INTO city VALUES (DEFAULT, 'Shanghai',   'UTC+08:00');
INSERT INTO city VALUES (DEFAULT, 'Chicago',    'UTC-05:00');
INSERT INTO city VALUES (DEFAULT, 'New York',   'UTC-04:00');
INSERT INTO city VALUES (DEFAULT, 'Tokyo',      'UTC+09:00');
INSERT INTO city VALUES (DEFAULT, 'London',     'UTC+01:00');
INSERT INTO city VALUES (DEFAULT, 'San Diago',  'UTC-07:00');

-- flight
INSERT INTO flight VALUES (DEFAULT, '2000-01-01 00:00:00', '2000-01-02 00:18:00', 1, 2, 3);
