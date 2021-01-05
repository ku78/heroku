insert into orders
(id, created, changed, user_id, sum, address, status) values
(1, '2020-12-18', '2020-12-18', 1, 100.0, 'Address 1', 'APPROVED');
alter sequence orders_seq restart with 2;

insert into orders_products
(id, order_id, product_id, amount, price) values
(1, 1, 1, 2, 20),
(2, 1, 2, 1, 30),
(3, 1, 3, 3, 30);
alter sequence orders_products_seq restart with 4;