-- Change to the database (PostgreSQL uses \c to connect to a database)
--\c employee_directory;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

-- Table structure for table users
CREATE TABLE users (
  username VARCHAR(50) PRIMARY KEY,
  password CHAR(68) NOT NULL,
  enabled BOOLEAN NOT NULL
);

-- Inserting data into the users table
-- The passwords are encrypted using BCrypt
INSERT INTO users (username, password, enabled) VALUES 
('john', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE),
('mary', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE),
('susan', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE);

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
