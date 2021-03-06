\c flight_db

------- INSERT DATA -------

-- role
INSERT INTO role VALUES
    (DEFAULT, 'admin'),
    (DEFAULT, 'user');

-- account
INSERT INTO account VALUES
    (DEFAULT, 'admin', 'admin', 1),
    (DEFAULT, 'demo', 'demo', 2),
    (DEFAULT, 'customer', 'customer', 2);

-- airplane
INSERT INTO airplane VALUES
    (DEFAULT, 'Boeing 707', 10, 20, 50),
    (DEFAULT, 'Boeing 727', 15, 25, 70),
    (DEFAULT, 'Boeing 757', 20, 20, 80),
    (DEFAULT, 'Boeing 767', 20, 20, 60),
    (DEFAULT, 'Boeing 777', 15, 20, 50),
    (DEFAULT, 'Boeing 787', 20, 30, 70),
    (DEFAULT, 'Airbus A320', 10, 20, 50),
    (DEFAULT, 'Airbus A330', 15, 25, 70),
    (DEFAULT, 'Airbus A380', 20, 30, 80);

-- city
INSERT INTO location VALUES
    (DEFAULT, 'Shanghai',   'UTC+08:00'),
    (DEFAULT, 'Chicago',    'UTC-05:00'),
    (DEFAULT, 'New York',   'UTC-04:00'),
    (DEFAULT, 'Tokyo',      'UTC+09:00'),
    (DEFAULT, 'London',     'UTC+01:00'),
    (DEFAULT, 'San Diago',  'UTC-07:00');

-- flight
INSERT INTO flight VALUES
    (DEFAULT, '2000-01-01T00:00:00'::TIMESTAMP, '2000-01-02T11:40:00'::TIMESTAMP, 1, 2, 1),
    (DEFAULT, '2000-01-01T00:00:00'::TIMESTAMP, '2000-01-02T05:18:00'::TIMESTAMP, 3, 5, 2),
    (DEFAULT, '2000-01-01T00:00:00'::TIMESTAMP, '2000-01-01T20:08:00'::TIMESTAMP, 4, 6, 3),
    (DEFAULT, '2000-01-01T00:00:00'::TIMESTAMP, '2000-01-02T03:10:00'::TIMESTAMP, 5, 2, 4),
    (DEFAULT, '2000-01-01T00:00:00'::TIMESTAMP, '2000-01-02T16:30:00'::TIMESTAMP, 2, 5, 5);

-- status
INSERT INTO status VALUES
    (DEFAULT, 'pending'),
    (DEFAULT, 'publish'),
    (DEFAULT, 'freeze');
