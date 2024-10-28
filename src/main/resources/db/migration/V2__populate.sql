INSERT INTO product (id, name, cost, description, rating, picture, category, manufacturer)
VALUES
    -- Battery
    (NEXTVAL('product_seq_id'), 'Літієва батарея 12В', 1500, 'Надійна батарея для зберігання енергії', 5, 'battery_12v.jpg', 0, 'CATL'),
    (NEXTVAL('product_seq_id'), 'Акумулятор 18650', 300, 'Літієвий акумулятор 3.7В', 4, 'battery_18650.jpg', 0, 'Envision'),
    (NEXTVAL('product_seq_id'), 'Батарея AGM 6В', 700, 'Надійна свинцева батарея', 3, 'battery_agm.jpg', 0, 'CATL'),
    (NEXTVAL('product_seq_id'), 'LiFePO4 батарея 24В', 2500, 'Екологічна батарея великої ємності', 5, 'battery_lifepo4.jpg', 0, 'EVE'),

    -- BMS
    (NEXTVAL('product_seq_id'), 'BMS для батарей 24В', 1000, 'Балансуюча система для 24В батарей', 4, 'bms_24v.jpg', 1, 'JKONG'),
    (NEXTVAL('product_seq_id'), 'BMS для 12В', 800, 'БМС для акумуляторів 12В', 4, 'bms_12v.jpg', 1, 'JKONG'),
    (NEXTVAL('product_seq_id'), 'BMS для LiFePO4', 1200, 'Балансуюча система для LiFePO4', 5, 'bms_lifepo4.jpg', 1, 'JKONG'),
    (NEXTVAL('product_seq_id'), 'BMS з Bluetooth', 1500, 'Система з підтримкою Bluetooth', 4, 'bms_bluetooth.jpg', 1, 'JKONG'),

    -- Inverter
    (NEXTVAL('product_seq_id'), 'Інвертор 500Вт', 2000, 'Інвертор на 500 Вт з низьким споживанням', 4, 'inverter_500w.jpg', 2, 'DATOUBOSS'),
    (NEXTVAL('product_seq_id'), 'Інвертор 1000Вт', 3000, 'Інвертор на 1000 Вт', 5, 'inverter_1000w.jpg', 2, 'VERICA'),
    (NEXTVAL('product_seq_id'), 'Інвертор 2000Вт', 5000, 'Інвертор на 2000 Вт', 5, 'inverter_2000w.jpg', 2, 'DATOUBOSS'),
    (NEXTVAL('product_seq_id'), 'Міні інвертор 300Вт', 1500, 'Компактний інвертор на 300 Вт', 3, 'inverter_300w.jpg', 2, 'DATOUBOSS'),

    -- PowerBlock
    (NEXTVAL('product_seq_id'), 'Блок живлення 12-24В', 2500, 'Регульований блок живлення', 3, 'power_block.jpg', 3, 'China'),
    (NEXTVAL('product_seq_id'), 'Блок живлення 5В', 1000, 'Компактний блок живлення 5В', 4, 'power_block_5v.jpg', 3, 'China'),
    (NEXTVAL('product_seq_id'), 'Блок живлення 48В', 4000, 'Блок живлення високої напруги', 5, 'power_block_48v.jpg', 3, 'Japan'),
    (NEXTVAL('product_seq_id'), 'Регульований блок 1-24В', 2800, 'Блок живлення з регулюванням напруги', 4, 'power_block_adj.jpg', 3, 'China'),

    -- Wire
    (NEXTVAL('product_seq_id'), 'Кабель мідний 2.5мм', 100, 'Мідний кабель з високою провідністю', 5, 'wire_2.5mm.jpg', 4, 'China'),
    (NEXTVAL('product_seq_id'), 'Кабель алюмінієвий 1.5мм', 80, 'Алюмінієвий кабель', 4, 'wire_1.5mm.jpg', 4, 'China'),
    (NEXTVAL('product_seq_id'), 'Кабель 3мм червоний', 120, 'Мідний кабель червоного кольору', 5, 'wire_3mm.jpg', 4, 'Ukraine'),
    (NEXTVAL('product_seq_id'), 'Кабель 4мм чорний', 150, 'Мідний кабель чорного кольору', 5, 'wire_4mm.jpg', 4, 'EU'),

    -- WireLug
    (NEXTVAL('product_seq_id'), 'Клема на 2.5мм кабель', 50, 'Клема для мідного кабелю', 4, 'wire_lug_2.5mm.jpg', 5, 'Ukraine'),
    (NEXTVAL('product_seq_id'), 'Клема на 4мм кабель', 60, 'Клема для великого перерізу', 4, 'wire_lug_4mm.jpg', 5, 'Ukraine'),
    (NEXTVAL('product_seq_id'), 'Клема мідна 1.5мм', 40, 'Мідна клема', 3, 'wire_lug_1.5mm.jpg', 5, 'China'),
    (NEXTVAL('product_seq_id'), 'Клема алюмінієва 3мм', 45, 'Алюмінієва клема', 3, 'wire_lug_3mm.jpg', 5, 'EU'),

    -- Miscellaneous
    (NEXTVAL('product_seq_id'), 'Ізолента', 20, 'Ізоляційна стрічка високої якості', 3, 'tape.jpg', 6, 'Ukraine'),
    (NEXTVAL('product_seq_id'), 'Кабельні хомути', 10, 'Нейлонові хомути для кабелів', 4, 'cable_ties.jpg', 6, 'Ukraine'),
    (NEXTVAL('product_seq_id'), 'Шайби 6мм', 15, 'Комплект оцинкованих шайб', 3, 'washers.jpg', 6, 'China'),
    (NEXTVAL('product_seq_id'), 'Скотч двосторонній', 30, 'Двосторонній скотч для електроніки', 4, 'double_tape.jpg', 6, 'China');

-- Додавання записів у таблиці з урахуванням специфіки кожної сутності

-- Battery
INSERT INTO battery (battery_id, battery_terminal_diameter, capacity, form, nominal_voltage)
VALUES
    (1, 5, 2000, 1, 12),
    (2, 2, 2500, 0, 4),
    (3, 4, 5000, 1, 6),
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

