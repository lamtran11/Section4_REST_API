-- Change to the database (PostgreSQL uses \c to connect to a database)
\c employee_directory;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

-- Table structure for table users
CREATE TABLE users (
  username VARCHAR(50) PRIMARY KEY,
  password VARCHAR(50) NOT NULL,
  enabled BOOLEAN NOT NULL
);

-- Inserting data into the users table
INSERT INTO users (username, password, enabled) VALUES 
('john', '{noop}test123', TRUE),
('mary', '{noop}test123', TRUE),
('susan', '{noop}test123', TRUE);

-- Table structure for table authorities
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  CONSTRAINT authorities_unique UNIQUE (username, authority),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);

-- Inserting data into the authorities table
INSERT INTO authorities (username, authority) VALUES 
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');
