insert into products
(id, title, description, price) values
(1, 'Product 1', 'Description 1', 32.0),
(2, 'Product 2', 'Description 2', 80.0),
(3, 'Product 3', 'Description 3', 80.0),
(4, 'Product 4', 'Description 4', 30.0),
(5, 'Product 5', 'Description 5', 10.0),
(6, 'Product 6', 'Description 6', 20.0),
(7, 'Product 7', 'Description 7', 30.0),
(8, 'Product 8', 'Description 8', 40.0),
(9, 'Product 9', 'Description 9', 50.0),
(10, 'Product 10', 'Description 10', 60.0);

alter sequence products_seq restart with 11;