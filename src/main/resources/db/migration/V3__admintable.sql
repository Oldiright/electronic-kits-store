
CREATE SEQUENCE seq_admin_id
    INCREMENT 1
    START 1;

CREATE TABLE admin_user (
    -- Використовуємо DEFAULT nextval для приєднання послідовності до колонки ID
    id BIGINT PRIMARY KEY DEFAULT nextval('seq_admin_id'),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    tel_number VARCHAR(20),
    password VARCHAR(255) NOT NULL,
    is_enabled BOOLEAN DEFAULT TRUE
);

COMMENT ON TABLE admin_user IS 'Основна сутність адміністративного користувача';

CREATE TABLE admin_role (
    admin_id BIGINT NOT NULL,
    role_name VARCHAR(50) NOT NULL,

    PRIMARY KEY (admin_id, role_name),

    -- Встановлення зовнішнього ключа
    CONSTRAINT fk_admin_user_role
        FOREIGN KEY (admin_id)
        REFERENCES admin_user (id)
        ON DELETE CASCADE
);

COMMENT ON TABLE admin_role IS 'Таблиця для зберігання ролей адміністраторів';