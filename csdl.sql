-- ADMIN
CREATE TABLE admin (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- PRODUCT
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    price DECIMAL(12,2) NOT NULL,
    stock INT NOT NULL
);

-- CUSTOMER
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    address TEXT
);

-- INVOICE
CREATE TABLE invoice (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(12,2)
);

-- INVOICE DETAIL
CREATE TABLE invoice_details (
    id SERIAL PRIMARY KEY,
    invoice_id INT REFERENCES invoice(id),
    product_id INT REFERENCES product(id),
    quantity INT,
    unit_price DECIMAL(12,2)
);

-- ADMIN
INSERT INTO admin(username, password)
VALUES ('admin', '123');

-- PRODUCT
INSERT INTO product(name, brand, price, stock) VALUES
('iPhone 15', 'Apple', 20000000, 10),
('Samsung S23', 'Samsung', 18000000, 15),
('Xiaomi 13', 'Xiaomi', 12000000, 20),
('Oppo Reno', 'Oppo', 9000000, 12);

-- CUSTOMER
INSERT INTO customer(name, phone, email, address) VALUES
('Nguyen Van A', '0901234567', 'a@gmail.com', 'Ha Noi'),
('Tran Thi B', '0912345678', 'b@gmail.com', 'HCM'),
('Le Van C', '0923456789', 'c@gmail.com', 'Da Nang');

SELECT * FROM product;
SELECT * FROM customer;