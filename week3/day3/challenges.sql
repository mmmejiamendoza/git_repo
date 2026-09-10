-- 1. get all fields and records from customer
SELECT * 
FROM customer;

-- 2. Get all fields from customer, but only if they are from Arizona
SELECT * 
FROM customer
WHERE state = 'AZ';

-- 3. Get all invoices older than 6 months 
SELECT *
FROM invoice
WHERE invoice_date <= NOW() - INTERVAL '6 months';

-- 4. Update all customer phone numbers to NULL if they don’t follow this format: ‘+1 555 555-5555’
UPDATE customer
SET phone = NULL
WHERE phone !~ '^\+1 \d{3} \d{3}-\d{4}$';

-- 5. Get all tracks that are longer than 180000 milliseconds 
SELECT *
FROM track
WHERE milliseconds > 180000;

-- 6. Update all customers not in the USA so that their country=USA and address, city, & state are NULL
UPDATE customer
SET country = 'USA',
    address = NULL,
    city = NULL,
    state = NULL
WHERE country != 'USA';

-- 7. Given a customer_id, return their total spending across all invoices using a function 
CREATE FUNCTION get_customer_total(p_customer_id INT)
RETURNS NUMERIC
AS $$
DECLARE
    result NUMERIC;
BEGIN
    SELECT SUM(total) INTO result
    FROM invoice
    WHERE customer_id = p_customer_id;
    RETURN result;
END;
$$ LANGUAGE plpgsql;

-- 8. Given an employee_id + new_manager_id, create a stored procedure to update an Employee’s ReportsTo field.
CREATE OR REPLACE PROCEDURE update_employee_manager(
    p_employee_id INT,
    p_new_manager_id INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE employee
    SET reports_to = p_new_manager_id
    WHERE employee_id = p_employee_id;
END;
$$;

-- 9. Prevent an employee reporting to themselves, reporting to a non-existence employee, or creating a circular management relationship
CREATE OR REPLACE PROCEDURE update_employee_manager(
    p_employee_id INT,
    p_new_manager_id INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    manager_exists INT;
    current_manager INT;
BEGIN

    IF p_employee_id = p_new_manager_id THEN
        RAISE EXCEPTION 'Employee % cannot report to themselves', p_employee_id;
    END IF;

    SELECT COUNT(*) INTO manager_exists
    FROM employee
    WHERE employee_id = p_new_manager_id;

    IF manager_exists = 0 THEN
        RAISE EXCEPTION 'Manager % does not exist', p_new_manager_id;
    END IF;

    current_manager := p_new_manager_id;
    WHILE current_manager IS NOT NULL LOOP
        IF current_manager = p_employee_id THEN
            RAISE EXCEPTION 'This assignment would create a circular management relationship';
        END IF;
        SELECT reports_to INTO current_manager
        FROM employee
        WHERE employee_id = current_manager;
    END LOOP;

    UPDATE employee
    SET reports_to = p_new_manager_id
    WHERE employee_id = p_employee_id;
END;
$$;

-- 10. Create a new schema: pets
CREATE SCHEMA pets;

-- 11. Create two related tables: Customer + Pets
CREATE TABLE pets.customer (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE pets.pet (
    pet_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES pets.customer(customer_id),
    pet_name VARCHAR(50) NOT NULL,
    species VARCHAR(50)
);

-- 12. Demonstrate populating records into these tables
INSERT INTO pets.customer (customer_id, first_name, last_name)
VALUES (1, 'Luis', 'Gonzalez'),
       (2, 'Leonie', 'Kohler');

INSERT INTO pets.pet (customer_id, pet_name, species)
VALUES (1, 'Rex', 'Dog'),
       (1, 'Whiskers', 'Cat'),
       (2, 'Tweety', 'Bird');