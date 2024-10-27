CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1 INCREMENT BY 50;
CREATE TABLE IF NOT EXISTS product (
    id BIGINT NOT NULL PRIMARY KEY,
    cost INTEGER,
    rating TINYINT,
    description VARCHAR(1000),
    name VARCHAR(120),
    picture VARCHAR(255),
    category TINYINT
);

-- Створюємо таблицю battery
CREATE TABLE IF NOT EXISTS battery (
    battery_id BIGINT NOT NULL PRIMARY KEY,
    battery_terminal_diameter INTEGER,
    capacity INTEGER,
    form TINYINT CHECK (form BETWEEN 0 AND 1),
    nominal_voltage INTEGER,
    FOREIGN KEY (battery_id) REFERENCES product(id)
);

-- Створюємо таблицю bms
CREATE TABLE IF NOT EXISTS bms (
    bms_id BIGINT NOT NULL PRIMARY KEY,
    balancer_type TINYINT CHECK (balancer_type BETWEEN 0 AND 1),
    bluetooth_availability BOOLEAN,
    max_power INTEGER,
    max_string_supported INTEGER,
    min_string_supported INTEGER,
    FOREIGN KEY (bms_id) REFERENCES product(id)
);

-- Створюємо таблицю inverter
CREATE TABLE IF NOT EXISTS inverter (
    inverter_id BIGINT NOT NULL PRIMARY KEY,
    input_voltage TINYINT CHECK (input_voltage BETWEEN 0 AND 1),
    power INTEGER,
    FOREIGN KEY (inverter_id) REFERENCES product(id)
);

-- Створюємо таблицю miscellaneous
CREATE TABLE IF NOT EXISTS miscellaneous (
    miscellaneous_id BIGINT NOT NULL PRIMARY KEY,
    other_info JSON,
    FOREIGN KEY (miscellaneous_id) REFERENCES product(id)
);

-- Створюємо таблицю power_block
CREATE TABLE IF NOT EXISTS power_block (
    power_block_id BIGINT NOT NULL PRIMARY KEY,
    max_voltage INTEGER,
    min_voltage INTEGER,
    power INTEGER,
    FOREIGN KEY (power_block_id) REFERENCES product(id)
);

-- Створюємо таблицю wire
CREATE TABLE IF NOT EXISTS wire (
    wire_id BIGINT NOT NULL PRIMARY KEY,
    cross_sectional_area INTEGER,
    color VARCHAR(50),
    insulation_material VARCHAR(100),
    FOREIGN KEY (wire_id) REFERENCES product(id)
);

-- Створюємо таблицю wire_lug
CREATE TABLE IF NOT EXISTS wire_lug (
    wire_lug_id BIGINT NOT NULL PRIMARY KEY,
    terminal_diameter INTEGER,
    wire_cross_sectional_area INTEGER,
    material VARCHAR(50),
    FOREIGN KEY (wire_lug_id) REFERENCES product(id)
);