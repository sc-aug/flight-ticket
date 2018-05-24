\connect flight_db

-- get flight info

SELECT
    flight_id,
    relative_departure_time,
    relative_arrival_time,
    c1.city_name,
    c2.city_name,
    a.airplane_name
FROM flight f
LEFT JOIN city c1
ON f.departure_city_id = c1.city_id
LEFT JOIN city c2
ON f.arrival_city_id = c2.city_id
LEFT JOIN airplane a
ON f.airplane_id = a.airplane_id

-- 