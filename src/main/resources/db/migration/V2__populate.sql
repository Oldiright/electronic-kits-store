INSERT INTO product (
    id,
    name,
    cost,
    description,
    rating,
    picture,
    category,
    manufacturer,
    quantity_in_stock,
    is_available,
    created_at,
    updated_at)
VALUES
    -- Battery
-- Battery (Category 0)
    (NEXTVAL('product_seq_id'), 'Літієва батарея 12В', 14400, 'Надійна батарея для зберігання енергії', 5, '/battery/1/battery_12v.jpg', 0, 'Jsdsolar', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Акумулятор 18650', 199, 'Літієвий акумулятор 3.7В', 4, '/battery/2/battery_18650.jpg', 0, 'Samsung', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Батарея AGM 6В', 210, 'Надійна свинцева батарея', 3, '/battery/3/battery_agm.jpg', 0, 'Merlion', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'LiFePO4 батарея 24В', 2500, 'Екологічна батарея великої ємності', 5, '/battery/4/battery_lifepo4.jpg', 0, 'Jsdsolar', 100, TRUE, NOW(), NOW()),

    -- BMS (Category 1)
    (NEXTVAL('product_seq_id'), 'BMS для батарей 24В', 1000, 'Балансуюча система для 24В батарей', 4, '/bms/5/bms_24v.jpg', 1, 'Smart BMS', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'BMS для 12В', 800, 'БМС для акумуляторів 12В', 4, '/bms/6/bms_12v.jpg', 1, 'JKONG', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'BMS для LiFePO4', 1200, 'Балансуюча система для LiFePO4', 5, '/bms/7/bms_lifepo4.jpg', 1, 'China', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'BMS з Bluetooth', 1500, 'Система з підтримкою Bluetooth', 4, '/bms/8/bms_bluetooth.jpg', 1, 'JKONG', 100, TRUE, NOW(), NOW()),

    -- Inverter (Category 2)
    (NEXTVAL('product_seq_id'), 'Інвертор 500Вт', 2000, 'Інвертор на 500 Вт з низьким споживанням', 4, '/inverter/9/inverter_500w.jpg', 2, 'UKC', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Інвертор 1000Вт', 3000, 'Інвертор на 1000 Вт', 5, '/inverter/10/inverter_1000w.jpg', 2, 'VERICA', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Інвертор 2000Вт', 11499, 'Інвертор на 2000 Вт', 5, '/inverter/11/inverter_2000w.jpg', 2, 'DATOUBOSS', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Міні інвертор 300Вт', 1500, 'Компактний інвертор на 300 Вт', 3, '/inverter/12/inverter_300w.jpg', 2, 'ALCA', 100, TRUE, NOW(), NOW()),

    -- PowerBlock (Category 3)
    (NEXTVAL('product_seq_id'), 'Блок живлення 12-36В', 2500, 'Регульований блок живлення', 3, '/powerblock/13/power_block.jpg', 3, 'China', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Блок живлення 5В', 1000, 'Компактний блок живлення 5В', 4, '/powerblock/14/power_block_5v.jpg', 3, 'China', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Блок живлення 48В', 4000, 'Блок живлення високої напруги', 5, '/powerblock/15/power_block_48v.jpg', 3, 'Japan', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Регульований блок 1-24В', 2800, 'Блок живлення з регулюванням напруги', 4, '/powerblock/16/power_block_adj.jpg', 3, 'China', 100, TRUE, NOW(), NOW()),

    -- Wire (Category 4)
    (NEXTVAL('product_seq_id'), 'Кабель мідний 2.5мм', 100, 'Мідний кабель з високою провідністю', 5, '/wire/17/wire_2.5mm.jpg', 4, 'China', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Кабель алюмінієвий 2.5мм', 80, 'Алюмінієвий кабель', 4, '/wire/18/wire_1.5mm.jpg', 4, 'China', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Кабель 3.4мм червоний', 120, 'Мідний кабель червоного кольору', 5, '/wire/19/wire_3.4mm.jpg', 4, 'Ukraine', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Кабель 4мм чорний', 150, 'Мідний кабель чорного кольору', 5, '/wire/20/wire_3.4mmBLACK.jpg', 4, 'EU', 100, TRUE, NOW(), NOW()),

    -- WireLug (Category 5)
    (NEXTVAL('product_seq_id'), 'Клема на 2.5мм кабель', 50, 'Клема для мідного кабелю', 4, '/wirelug/21/wire_lug_2.5mm.jpg', 5, 'Ukraine', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Клема на 4.8мм кабель', 60, 'Клема для великого перерізу', 4, '/wirelug/22/wire_lug_4.8mm.jpg', 5, 'Ukraine', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Клема мідна 1.5мм', 40, 'Мідна клема', 3, '/wirelug/23/wire_lug_1.5mm.jpg', 5, 'China', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Клема алюмінієва 3мм', 45, 'Алюмінієва клема', 3, '/wirelug/24/wire_lug_3mm.jpg', 5, 'EU', 100, TRUE, NOW(), NOW()),

    -- Miscellaneous (Category 6)
    (NEXTVAL('product_seq_id'), 'Ізолента', 20, 'Ізоляційна стрічка високої якості', 3, '/miscellaneous/25/tape.jpg', 6, 'Ukraine', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Кабельні хомути', 10, 'Нейлонові хомути для кабелів', 4, '/miscellaneous/26/cable_ties.jpg', 6, 'Ukraine', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Шайби 6мм', 15, 'Комплект оцинкованих шайб', 3, '/miscellaneous/27/washers.jpg', 6, 'China', 100, TRUE, NOW(), NOW()),
    (NEXTVAL('product_seq_id'), 'Скотч двосторонній', 30, 'Двосторонній скотч для електроніки', 4, '/miscellaneous/28/double_tape.jpg', 6, 'China', 100, TRUE, NOW(), NOW());

-- Додавання записів у таблиці з урахуванням специфіки кожної сутності

-- Battery
INSERT INTO battery (battery_id, battery_terminal_diameter, capacity, form, nominal_voltage)
VALUES
    (1, 5, 200, 0, 12),
    (2, 2, 3, 1, 3),
    (3, 4, 6, 1, 6),
    (4, 5, 8000, 1, 24);

-- BMS
INSERT INTO bms (bms_id, balancer_type, bluetooth_availability, max_power, max_string_supported, min_string_supported)
VALUES
    (5, 0, true, 100, 6, 2),
    (6, 1, false, 150, 8, 3),
    (7, 1, true, 200, 10, 5),
    (8, 0, true, 250, 12, 4);

-- Inverter
INSERT INTO inverter (inverter_id, input_voltage, power)
VALUES
    (9, 1, 500),
    (10, 1, 1000),
    (11, 0, 2000),
    (12, 1, 300);

-- PowerBlock
INSERT INTO power_block (power_block_id, min_voltage, max_voltage, power)
VALUES
    (13, 12, 24, 150),
    (14, 5, 5, 50),
    (15, 48, 48, 400),
    (16, 1, 24, 280);

-- Wire
INSERT INTO wire (wire_id, cross_sectional_area, color, insulation_material)
VALUES
    (17, 2, 'Червоний', 'ПВХ'),
    (18, 1, 'Чорний', 'ПВХ'),
    (19, 3, 'Червоний', 'ПВХ'),
    (20, 4, 'Чорний', 'ПВХ');

-- WireLug
INSERT INTO wire_lug (wire_lug_id, terminal_diameter, wire_cross_sectional_area, material)
VALUES
    (21, 2, 2, 'Мідь'),
    (22, 4, 4, 'Мідь'),
    (23, 1, 1, 'Алюміній'),
    (24, 3, 3, 'Алюміній');

-- Miscellaneous з динамічними характеристиками у полі other_info
INSERT INTO miscellaneous (miscellaneous_id, other_info)
VALUES
    (25, JSON '{"brand": "ElectroBest", "temperature_resistance": "до 100°C", "width": "19мм", "color": "чорний"}'),
    (26, JSON '{"type": "кабельні хомути", "length": "100мм", "material": "нейлон", "package_count": "100 шт."}'),
    (27, JSON '{"type": "шайба", "material": "оцинкована сталь", "diameter": "6мм"}'),
    (28, JSON '{"type": "двосторонній скотч", "adhesive_strength": "середня", "width": "15мм", "length": "10м"}');

