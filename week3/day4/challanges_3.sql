-- 1. Create a new table called record_logs:
-- Fields: log_id, record_id, field_changed, last_update, old_value, new_value 
CREATE TABLE record_logs(
    log_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    record_id INT,
    field_changed TEXT,
    last_update TIMESTAMP,
    old_value VARCHAR(50),
    new_value VARCHAR(50)
)

-- this is to add the customer table to the record_logs so it can answer question 2
ALTER TABLE record_logs
ADD CONSTRAINT fk_record_logs_customer
FOREIGN KEY (record_id) REFERENCES customer(customer_id);


-- 2. Create a trigger that tracks changes to customer records and logs the changes in our new table
CREATE OR REPLACE FUNCTION log_customer_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.first_name IS DISTINCT FROM OLD.first_name THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'first_name', NOW(), OLD.first_name, NEW.first_name);
    END IF;
    IF NEW.last_name IS DISTINCT FROM OLD.last_name THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'last_name', NOW(), OLD.last_name, NEW.last_name);
    END IF;
    IF NEW.company IS DISTINCT FROM OLD.company THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'company', NOW(), OLD.company, NEW.company);
    END IF;
    IF NEW.address IS DISTINCT FROM OLD.address THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'address', NOW(), OLD.address, NEW.address);
    END IF;
    IF NEW.city IS DISTINCT FROM OLD.city THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'city', NOW(), OLD.city, NEW.city);
    END IF;
    IF NEW.state IS DISTINCT FROM OLD.state THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'state', NOW(), OLD.state, NEW.state);
    END IF;
    IF NEW.country IS DISTINCT FROM OLD.country THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'country', NOW(), OLD.country, NEW.country);
    END IF;
    IF NEW.postal_code IS DISTINCT FROM OLD.postal_code THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'postal_code', NOW(), OLD.postal_code, NEW.postal_code);
    END IF;
    IF NEW.phone IS DISTINCT FROM OLD.phone THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'phone', NOW(), OLD.phone, NEW.phone);
    END IF;
    IF NEW.fax IS DISTINCT FROM OLD.fax THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'fax', NOW(), OLD.fax, NEW.fax);
    END IF;
    IF NEW.email IS DISTINCT FROM OLD.email THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'email', NOW(), OLD.email, NEW.email);
    END IF;
    IF NEW.support_rep_id IS DISTINCT FROM OLD.support_rep_id THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'support_rep_id', NOW(), OLD.support_rep_id, NEW.support_rep_id);
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_log_customer_changes
AFTER UPDATE ON customer
FOR EACH ROW
EXECUTE FUNCTION log_customer_changes();