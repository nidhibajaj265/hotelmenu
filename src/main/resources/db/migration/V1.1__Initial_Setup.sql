CREATE TABLE IF NOT EXISTS menu_items (
    id int NOT NULL PRIMARY KEY,
    name varchar(100) NOT NULL,
    price double precision NOT NULL,
    item_type varchar(100) NOT NULL
);

INSERT INTO menu_items(id, name, price, item_type) VALUES ('1', 'Pooji Bhaji', '120.5', 'BREAKFAST');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('2', 'Dosa Sambhar', '130.75', 'BREAKFAST');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('3', 'Aloo Parantha', '110.5', 'BREAKFAST');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('4', 'Kadhai Paneer ', '230.7', 'LUNCH');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('5', 'Dal Tadka', '240.8', 'LUNCH');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('6', 'Mix Veg', '180.5', 'LUNCH');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('7', 'Rajma Rice', '180.5', 'DINNER');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('8', 'Chhole Rice', '190.5', 'DINNER');
INSERT INTO menu_items(id, name, price, item_type) VALUES ('9', 'Kadhi Rice', '200.7', 'DINNER');