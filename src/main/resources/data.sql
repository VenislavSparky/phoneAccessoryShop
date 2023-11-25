INSERT INTO users (first_name, last_name, email, password, age, active)
VALUES ('admin', 'adminov', 'admin@example.com', '513a48da81eeff9a0bc84279ee002f3113533f5f4488af4eb61b8e237917f976a3e4eef237309ea95f4d77d608e4eba7', 30, true),
       ('Alice', 'Smith', 'alice.smith@example.com', '$pbkdf2-sha256$10000$xyzabc$pqrstuvw1234567890', 30, true),
       ('Bob', 'Johnson', 'bob.johnson@example.com', '$pbkdf2-sha256$10000$lmnopq$abcdefgh1234567890', 28, true),
       ('Emily', 'White', 'emily.white@example.com', '$pbkdf2-sha256$10000$ijklmn$opqrstuvwxyz1234567890', 35, true),
       ('Michael', 'Brown', 'michael.brown@example.com', '$pbkdf2-sha256$10000$defghi$jklmnopq1234567890', 32, true),
       ('Sarah', 'Miller', 'sarah.miller@example.com', '$pbkdf2-sha256$10000$opqrst$uvwxyzabc1234567890', 27, true);

INSERT INTO roles (`id`, `role`)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO users_roles(`user_id`, `role_id`)
VALUES (1, 1),
       (2, 2);

INSERT INTO phone_brands (name)
VALUES ('Apple'),
       ('Samsung'),
       ('Huawei'),
       ('Xiaomi'),
       ('OnePlus');

INSERT INTO phone_models (name, brand_id)
VALUES
    -- Apple
    ('iPhone 13', (SELECT id FROM phone_brands WHERE name = 'Apple')),
    ('iPhone 12 Pro', (SELECT id FROM phone_brands WHERE name = 'Apple')),
    ('iPhone SE', (SELECT id FROM phone_brands WHERE name = 'Apple')),
    ('iPhone 11', (SELECT id FROM phone_brands WHERE name = 'Apple')),
    ('iPhone XR', (SELECT id FROM phone_brands WHERE name = 'Apple')),

    -- Samsung
    ('Galaxy S21', (SELECT id FROM phone_brands WHERE name = 'Samsung')),
    ('Galaxy Note 20', (SELECT id FROM phone_brands WHERE name = 'Samsung')),
    ('Galaxy A52', (SELECT id FROM phone_brands WHERE name = 'Samsung')),
    ('Galaxy S20', (SELECT id FROM phone_brands WHERE name = 'Samsung')),
    ('Galaxy Z Fold 3', (SELECT id FROM phone_brands WHERE name = 'Samsung')),

    -- Huawei
    ('P40 Pro', (SELECT id FROM phone_brands WHERE name = 'Huawei')),
    ('Mate 40 Pro', (SELECT id FROM phone_brands WHERE name = 'Huawei')),
    ('Nova 7', (SELECT id FROM phone_brands WHERE name = 'Huawei')),
    ('P30', (SELECT id FROM phone_brands WHERE name = 'Huawei')),
    ('Mate X2', (SELECT id FROM phone_brands WHERE name = 'Huawei')),

    -- Xiaomi
    ('Mi 11', (SELECT id FROM phone_brands WHERE name = 'Xiaomi')),
    ('Redmi Note 10', (SELECT id FROM phone_brands WHERE name = 'Xiaomi')),
    ('POCO X3', (SELECT id FROM phone_brands WHERE name = 'Xiaomi')),
    ('Mi 10T Pro', (SELECT id FROM phone_brands WHERE name = 'Xiaomi')),
    ('Black Shark 4', (SELECT id FROM phone_brands WHERE name = 'Xiaomi')),

    -- OnePlus
    ('OnePlus 9 Pro', (SELECT id FROM phone_brands WHERE name = 'OnePlus')),
    ('OnePlus 8T', (SELECT id FROM phone_brands WHERE name = 'OnePlus')),
    ('OnePlus Nord 2', (SELECT id FROM phone_brands WHERE name = 'OnePlus')),
    ('OnePlus 9', (SELECT id FROM phone_brands WHERE name = 'OnePlus')),
    ('OnePlus 7 Pro', (SELECT id FROM phone_brands WHERE name = 'OnePlus'));
