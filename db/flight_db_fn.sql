\c flight_db

-- get first class seats by airplane id
DROP FUNCTION fn_get_seats_first;
CREATE OR REPLACE FUNCTION fn_get_seats_first(in a_id integer) RETURNS integer AS $$
DECLARE
    cnt_first integer := 0;
BEGIN
    SELECT min(seat_first) INTO cnt_first
    FROM airplane WHERE airplane_id = a_id;
    RETURN cnt_first;
END;
$$ LANGUAGE plpgsql VOLATILE;

-- get business seats by airplane id
DROP FUNCTION fn_get_seats_business;
CREATE OR REPLACE FUNCTION fn_get_seats_business(in a_id integer) RETURNS integer AS $$
DECLARE
    cnt_business integer := 0;
BEGIN
    SELECT min(seat_business) INTO cnt_business
    FROM airplane WHERE airplane_id = a_id;
    RETURN cnt_business;
END;
$$ LANGUAGE plpgsql VOLATILE;

-- get economy seats by airplane id
DROP FUNCTION fn_get_seats_economy;
CREATE OR REPLACE FUNCTION fn_get_seats_economy(in a_id integer) RETURNS integer AS $$
DECLARE
    cnt_economy integer := 0;
BEGIN
    SELECT min(seat_economy) INTO cnt_economy
    FROM airplane WHERE airplane_id = a_id;
    RETURN cnt_economy;
END;
$$ LANGUAGE plpgsql VOLATILE;

-- propagate available seats table
DROP FUNCTION propagate_seats;
CREATE OR REPLACE FUNCTION propagate_seats(integer, integer, integer, integer)
    RETURNS integer AS $$
DECLARE
    subcnt integer := 0;
    cnt INT := 0;
BEGIN

    LOOP
    EXIT WHEN subcnt = $1 ;
        subcnt := subcnt + 1 ;
        -- LOCK TABLE available_seat IN ROW EXCLUSIVE MODE;
        INSERT INTO available_seat VALUES ($4, 1, subcnt);
        -- RAISE NOTICE 'my cnt % % %', 1, 1, subcnt;
    END LOOP ;
    cnt := cnt + subcnt;
    subcnt := 0;

    LOOP
    EXIT WHEN subcnt = $2 ;
        subcnt := subcnt + 1 ;
        -- LOCK TABLE available_seat IN ROW EXCLUSIVE MODE;
        INSERT INTO available_seat VALUES ($4, 2, subcnt);
    END LOOP ;
    cnt := cnt + subcnt;
    subcnt := 0;

    LOOP
    EXIT WHEN subcnt = $3 ;
        subcnt := subcnt + 1 ;
        -- LOCK TABLE available_seat IN ROW EXCLUSIVE MODE;
        INSERT INTO available_seat VALUES ($4, 3, subcnt);
    END LOOP ;

    cnt := cnt + subcnt;
    RETURN cnt ;

END;
$$ LANGUAGE plpgsql VOLATILE;

-- create new schedule fires a serie of operations
--   - insert record in schedule
--   - insert record in schedule_seat
--   - insert record in available_seat
CREATE OR REPLACE FUNCTION fn_insert_schedule(f_id integer, dep timestamp) RETURNS integer AS $$
DECLARE
    inserted_s_id integer := -1 ;
    a_id integer := -1 ;
BEGIN

    SELECT min(airplane_id) INTO a_id
        FROM flight WHERE flight_id = f_id;

    INSERT INTO schedule VALUES (DEFAULT, f_id, 1, dep)
        RETURNING schedule_id INTO inserted_s_id;

    INSERT INTO schedule_seat
        SELECT
            schedule_id,
            seat_first,
            seat_business,
            seat_economy
        FROM schedule s
        INNER JOIN flight f
        ON s.flight_id = f.flight_id
        INNER JOIN airplane a
        ON f.airplane_id = a.airplane_id
        WHERE f.flight_id = f_id AND schedule_id = inserted_s_id;

    PERFORM propagate_seats(
            fn_get_seats_first(a_id),
            fn_get_seats_business(a_id),
            fn_get_seats_economy(a_id),
            inserted_s_id );

    RETURN inserted_s_id ;
END;
$$ LANGUAGE plpgsql VOLATILE;
