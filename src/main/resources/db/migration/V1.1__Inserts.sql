INSERT INTO BRAND (id, name) VALUES (1, 'Zara');
INSERT INTO PRODUCT (id, name, brand_id) VALUES (35455, 'product1', 1);

INSERT INTO PRICE 
    (price_list, price, priority, start_date, end_date, product_id, brand_id, currency) 
    VALUES 
    (1, 35.50, 0, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35455, 1, 'EUR');

INSERT INTO PRICE 
    (price_list, price, priority, start_date, end_date, product_id, brand_id, currency) 
    VALUES 
    (2, 25.45, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 35455, 1, 'EUR');

INSERT INTO PRICE 
    (price_list, price, priority, start_date, end_date, product_id, brand_id, currency) 
    VALUES 
    (3, 30.50, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 35455, 1, 'EUR');

INSERT INTO PRICE 
    (price_list, price, priority, start_date, end_date, product_id, brand_id, currency) 
    VALUES 
    (4, 38.95, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 35455, 1, 'EUR');