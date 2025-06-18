CREATE TABLE IF NOT EXISTS "user" (
    user_name VARCHAR(20) PRIMARY KEY,
    password VARCHAR(30) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    city VARCHAR(100) NOT NULL,
    hire_date TIMESTAMP NOT NULL
); 