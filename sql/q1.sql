\connect flight_db

-- get all flight info

SELECT
    flight_id,
    relative_departure_time,
    relative_arrival_time,
    c1.city_id,
    c2.city_id,
    a.airplane_id,
    c1.city_name,
    c2.city_name,
    airplane_name
FROM flight f
LEFT JOIN city c1
ON f.departure_city_id = c1.city_id
LEFT JOIN city c2
ON f.arrival_city_id = c2.city_id
LEFT JOIN airplane a
ON f.airplane_id = a.airplane_id;

-- get flight by id

SELECT
    flight_id,
    relative_departure_time,
    relative_arrival_time,
    c1.city_id,
    c2.city_id,
    a.airplane_id,
    c1.city_name,
    c2.city_name,
    airplane_name
FROM (
    SELECT * FROM flight
    WHERE flight_id = 1) f
LEFT JOIN city c1
ON f.departure_city_id = c1.city_id
LEFT JOIN city c2
ON f.arrival_city_id = c2.city_id
LEFT JOIN airplane a
ON f.airplane_id = a.airplane_id;

-- get all seat type info
SELECT
    seat_type_id,
    seat_type_name
FROM seat_type;

-- get all airplane info
SELECT
    airplane_id,
    airplane_name
FROM airplane;

-- get seat info by airplane
SELECT *
FROM airplane_seat
WHERE airplane_id = 1;