CREATE SEQUENCE IF NOT EXISTS product_seq_id
    START WITH 1
    INCREMENT BY 1;


CREATE TABLE IF NOT EXISTS product (
    id BIGINT DEFAULT nextval('product_seq_id'),
    cost NUMERIC,
    rating SMALLINT,
    description VARCHAR(1000),
    name VARCHAR(120) NOT NULL UNIQUE, -- Додано NOT NULL та UNIQUE
    manufacturer VARCHAR(50),
    picture VARCHAR(255),
    category SMALLINT,
    quantity_in_stock INTEGER DEFAULT 0,
    is_available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP, -- Автогенерація часу
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_product_id PRIMARY KEY (id),
    CONSTRAINT uq_product_name UNIQUE (name) -- Явний constraint для унікальності
);
-- Тригер для автоматичного оновлення updated_at
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_product_updated_at
    BEFORE UPDATE ON product
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

    -- Оновлення індексів (додаємо індекси для нових важливих полів, якщо потрібно):
    -- Індекси для пошуку:
CREATE INDEX IF NOT EXISTS idx_product_available ON product (is_available, quantity_in_stock);
CREATE INDEX IF NOT EXISTS idx_product_name ON product (name);
CREATE INDEX IF NOT EXISTS idx_product_manufacturer ON product (manufacturer);
CREATE INDEX IF NOT EXISTS idx_product_category ON product (category);
CREATE INDEX IF NOT EXISTS idx_product_cost ON product (cost);

-- Створюємо таблицю battery
CREATE TABLE IF NOT EXISTS battery (
    battery_id BIGINT NOT NULL PRIMARY KEY,
    battery_terminal_diameter INTEGER,
    capacity INTEGER,
    form SMALLINT CHECK (form BETWEEN 0 AND 1),
    nominal_voltage INTEGER,
    FOREIGN KEY (battery_id) REFERENCES product(id)
);

-- Створюємо таблицю bms
CREATE TABLE IF NOT EXISTS bms (
    bms_id BIGINT NOT NULL PRIMARY KEY,
    balancer_type SMALLINT CHECK (balancer_type BETWEEN 0 AND 1),
    bluetooth_availability BOOLEAN,
    max_power INTEGER,
    max_string_supported INTEGER,
    min_string_supported INTEGER,
    FOREIGN KEY (bms_id) REFERENCES product(id)
);

-- Створюємо таблицю inverter
CREATE TABLE IF NOT EXISTS inverter (
    inverter_id BIGINT NOT NULL PRIMARY KEY,
    input_voltage SMALLINT CHECK (input_voltage BETWEEN 0 AND 1),
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


CREATE TABLE IF NOT EXISTS customer (
    id BIGINT NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    tel_number VARCHAR(255)

    -- Обмеження: Унікальність на рівні таблиці для електронної пошти (додатково, якщо не підтримується на рівні колонки)
   -- CONSTRAINT uc_customer_email UNIQUE (email)
);
CREATE INDEX idx_customer_last_name ON customer (last_name);
CREATE INDEX idx_customer_tel_number ON customer (tel_number);



---

CREATE SEQUENCE IF NOT EXISTS seq_order_id
    INCREMENT BY 1
    START WITH 1
    CACHE 1;

CREATE TABLE IF NOT EXISTS orders (
    id BIGINT PRIMARY KEY NOT NULL,
    order_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    total_price NUMERIC(19, 2), -- 19 цифр загалом, 2 після коми
    order_status VARCHAR(255) NOT NULL, -- Використовуємо VARCHAR для сумісності з H2, хоча для PostgreSQL можна використати order_status_enum
    customer_id BIGINT NOT NULL,

    -- Обмеження зовнішнього ключа (Foreign Key)
    CONSTRAINT fk_order_customer
        FOREIGN KEY (customer_id)
        REFERENCES customer(id)
        ON DELETE RESTRICT
);

---

-- *** 4. Створення індексу для зовнішнього ключа ***
CREATE INDEX idx_order_customer_id ON orders (customer_id);

-- *** 1. Створення послідовності (Sequence) ***
-- Відповідає @SequenceGenerator(name = "customer_seq", sequenceName = "seq_customer_id")
CREATE SEQUENCE IF NOT EXISTS seq_customer_id
    INCREMENT BY 1
    START WITH 1
    CACHE 1;

-- Цей крок є обов'язковим для PostgreSQL і рекомендований для H2,
-- щоб відповідати конфігурації @SequenceGenerator
CREATE SEQUENCE IF NOT EXISTS seq_order_items_id
    INCREMENT BY 1
    START WITH 1
    CACHE 1;

---

-- Створення таблиці order_items
CREATE TABLE order_item (
    -- ID (Первинний ключ)
    -- Для PostgreSQL: використовуємо nextval з нашої послідовності
    -- Для H2: H2 підтримує SEQUENCE
    id BIGINT PRIMARY KEY,

    -- Кількість товару
    quantity INTEGER NOT NULL,

    -- Зв'язок ManyToOne з Order
    -- order_id має посилатися на первинний ключ таблиці "order"
    -- (припускаючи, що назва таблиці для класу Order - 'order', хоча це зазвичай 'orders')
    -- Якщо таблиця називається `orders`, змініть `order` на `orders`.
    order_id BIGINT NOT NULL,

    -- Зв'язок ManyToOne з Product
    -- product_id має посилатися на первинний ключ таблиці "product"
    -- (припускаючи, що назва таблиці для класу Product - 'product' або 'products')
    product_id BIGINT NOT NULL,

    -- Обмеження зовнішнього ключа (Foreign Key) для order_id
    -- ON DELETE CASCADE або ON DELETE RESTRICT слід обрати відповідно до бізнес-логіки.
    -- Зазвичай для елементів замовлення використовується RESTRICT або SET NULL,
    -- щоб не видалити елементи замовлення при випадковому видаленні самого замовлення (або навпаки).
    -- Приклад:
    CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id)
        ON DELETE CASCADE,

    -- Обмеження зовнішнього ключа (Foreign Key) для product_id
    CONSTRAINT fk_order_item_product
        FOREIGN KEY (product_id)
        REFERENCES product(id)
        ON DELETE RESTRICT
);

---

-- Створення індексів для покращення продуктивності пошуку за зовнішніми ключами
CREATE INDEX idx_order_item_order_id ON order_item (order_id);
CREATE INDEX idx_order_item_product_id ON order_item (product_id);


