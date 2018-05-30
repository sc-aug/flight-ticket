DROP DATABASE IF EXISTS flight_db;

CREATE DATABASE flight_db;

\connect flight_db

------- CREATE TABLES -------

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
    seat_first INT NOT NULL,
    seat_business INT NOT NULL,
    seat_economy INT NOT NULL,
    PRIMARY KEY (airplane_id)
);

-- location - ok
CREATE TABLE location (
    location_id SERIAL NOT NULL,
    location_name VARCHAR(50) NOT NULL,
    timezone VARCHAR(50) NOT NULL,
    PRIMARY KEY (location_id)
);

-- flight table - ok
CREATE TABLE flight (
    flight_id SERIAL NOT NULL,
    relative_departure_time TIMESTAMP NOT NULL,
    relative_arrival_time TIMESTAMP NOT NULL,
    departure_loc_id INT NOT NULL,
    arrival_loc_id INT NOT NULL,
    airplane_id INT NOT NULL,
    FOREIGN KEY (airplane_id) REFERENCES airplane (airplane_id),
    FOREIGN KEY (departure_loc_id) REFERENCES location (location_id),
    FOREIGN KEY (arrival_loc_id) REFERENCES location (location_id),
    PRIMARY KEY (flight_id)
);

-- status table - ok
CREATE TABLE status (
    status_id SERIAL,
    status_name VARCHAR(20),
    PRIMARY KEY (status_id)
);

-- schedule of flight table - ok
CREATE TABLE schedule (
    schedule_id SERIAL NOT NULL,
    flight_id INT NOT NULL,
    status_id INT NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flight (flight_id),
    FOREIGN KEY (status_id) REFERENCES status (status_id),
    PRIMARY KEY (schedule_id)
);

-- reserved seats - ok
CREATE TABLE schedule_seat (
    schedule_id INT NOT NULL UNIQUE,
    available_first INT NOT NULL,
    available_business INT NOT NULL,
    available_economy INT NOT NULL,
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id)
);

-- seat table - ok
CREATE TABLE available_seat (
    schedule_id INT NOT NULL,
    seat_class INT NOT NULL,
    seat_num INT NOT NULL,
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id),
    PRIMARY KEY (schedule_id, seat_class, seat_num)
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

------- CREATE VIEWS -------

CREATE VIEW view_flight_detail AS
    SELECT
        flight_id,
        a.airplane_id airplane_id,
        airplane_name,
        relative_departure_time departure_time,
        relative_arrival_time arrival_time,
        l1.location_id loc_dep_id,
        l2.location_id loc_arr_id,
        l1.location_name loc_dep_name,
        l2.location_name loc_arr_name
    FROM flight f
    LEFT JOIN location l1
    ON f.departure_loc_id = l1.location_id
    LEFT JOIN location l2
    ON f.arrival_loc_id = l2.location_id
    LEFT JOIN airplane a
    ON f.airplane_id = a.airplane_id
    ORDER BY flight_id;

CREATE VIEW view_account_info AS
    SELECT
        uid,
        username,
        password,
        a.role_id role_id,
        role_name
    FROM account a
    LEFT JOIN role r
    ON a.role_id = r.role_id;

CREATE VIEW view_schedule_info AS
    SELECT
        sc.schedule_id,
        sc.flight_id,
        sc.status_id,
        status_name,
        airplane_name,
        l1.location_name dep_loc_name,
        l2.location_name arr_loc_name,
        seat_first,
        seat_business,
        seat_economy,
        departure_time,
        relative_departure_time,
        relative_arrival_time
    FROM schedule sc
    INNER JOIN status
    ON sc.status_id = status.status_id
    LEFT JOIN schedule_seat scs
    ON sc.schedule_id = scs.schedule_id
    INNER JOIN flight f
    ON sc.flight_id = f.flight_id
    INNER JOIN airplane a
    ON f.airplane_id = a.airplane_id
    INNER JOIN location l1
    ON f.departure_loc_id = l1.location_id
    INNER JOIN location l2
    ON f.arrival_loc_id = l2.location_id;

